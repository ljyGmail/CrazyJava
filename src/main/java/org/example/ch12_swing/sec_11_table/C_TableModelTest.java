package org.example.ch12_swing.sec_11_table;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class C_TableModelTest {
    JFrame jf = new JFrame("数据表管理工具");
    private JScrollPane scrollPane;
    private ResultSetTableModel model;
    // 用于装载数据表的JComboBox
    private JComboBox<String> tableNames = new JComboBox<>();
    private JTextArea changeMsg = new JTextArea(4, 80);
    private ResultSet rs;
    private Connection conn;
    private Statement stmt;

    public void init() {
        // 为JComboBox添加事件监听器，当用户选择某个事件表时，触发该方法
        tableNames.addActionListener(event -> {
            try {
                // 如果装载JTable的JScrollPane不为空
                if (scrollPane != null) {
                    // 从主窗口中删除表格
                    jf.remove(scrollPane);
                }
                // 从JComboBox中取出用户试图管理的数据表的表名
                var tableName = (String) tableNames.getSelectedItem();
                // 如果结果集不为空，则关闭结果集
                if (rs != null) {
                    rs.close();
                }
                var query = "select * from " + tableName;
                // 查询用户选择的数据表
                rs = stmt.executeQuery(query);
                // 使用查询到的ResultSet创建TableModel对象
                model = new ResultSetTableModel(rs);
                // 为TableModel添加监听器，添加用户的修改
                model.addTableModelListener(evt -> {
                    int row = evt.getFirstRow();
                    int column = evt.getColumn();
                    changeMsg.append("修改的列:" + column
                            + "，修改的行: " + row + "修改后的值: "
                            + model.getValueAt(row, column));
                });
                // 使用TableModel创建JTable，并将对应表格添加到窗口中
                var table = new JTable(model);
                scrollPane = new JScrollPane(table);
                jf.add(scrollPane, BorderLayout.CENTER);
                jf.validate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        var p = new JPanel();
        p.add(tableNames);
        jf.add(p, BorderLayout.NORTH);
        jf.add(new JScrollPane(changeMsg), BorderLayout.SOUTH);
        try {
            // 获取数据库连接
            conn = getConnection();
            // 获取数据库的MetaData对象
            DatabaseMetaData meta = conn.getMetaData();
            // 创建Statement
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // 查询当前数据库的全部数据表
            ResultSet tables = meta.getTables(null, null, null, new String[]{"TABLE"});
            // 将全部数据表添加到JComboBox中
            while (tables.next()) {
                tableNames.addItem(tables.getString(3));
            }
            tables.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    private static Connection getConnection()
            throws SQLException, IOException, ClassNotFoundException {
        // 通过加载conn.ini文件来获取数据库连接的详细信息
        var props = new Properties();
        var in = new FileInputStream("conn.ini");
        props.load(in);
        in.close();
        var drivers = props.getProperty("jdbc.drivers");
        var url = props.getProperty("jdbc.url");
        var username = props.getProperty("jdbc.username");
        var password = props.getProperty("jdbc.password");
        // 加载数据库驱动
        Class.forName(drivers);
        // 获得数据库连接
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {
        new C_TableModelTest().init();
    }
}

// 扩展AbstractTableModel，用于将一个ResultSet包装成TableModel
class ResultSetTableModel extends AbstractTableModel {
    private ResultSet rs;
    private ResultSetMetaData rsmd;

    // 构造器，初始化rs和rsmd两个属性
    public ResultSetTableModel(ResultSet aResultSet) {
        rs = aResultSet;
        try {
            rsmd = rs.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 重写getColumnName方法，用于为该TableModel设置列名
    @Override
    public String getColumnName(int c) {
        try {
            return rsmd.getColumnName(c + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    // 重写getColumnCount方法，用于设置该TableModel的列数
    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // 重写getValueAt方法，用于设置该TableModel指定单元格的值
    @Override
    public Object getValueAt(int r, int c) {
        try {
            rs.absolute(r + 1);
            return rs.getObject(c + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 重写getRowCount方法，用于设置该TableModel的行数
    @Override
    public int getRowCount() {
        try {
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // 重写isCellEditable返回true，让每个单元格可编辑
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    // 重写setValueAt方法，当用户编辑单元格时，将会触发该方法

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        try {
            // 结果集定位到对应的行数
            rs.absolute(row + 1);
            // 修改单元格对应的值
            rs.updateObject(column + 1, aValue);
            // 提交修改
            rs.updateRow();
            // 触发单元格的修改事件
            fireTableCellUpdated(row, column);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}