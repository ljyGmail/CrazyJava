package org.example.ch12_swing.sec_11_table;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class E_SortTable {
    JFrame jf = new JFrame("可按列排序的表格");
    // 定义二维数组作为表格数据
    Object[][] tableData = {
            new Object[]{"李清照", 29, "女"},
            new Object[]{"苏格拉底", 56, "男"},
            new Object[]{"李白", 35, "男"},
            new Object[]{"弄玉", 18, "女"},
            new Object[]{"虎头", 2, "男"}
    };
    // 定义一维数据作为列标题
    Object[] columnTitle = {"姓名", "年龄", "性别"};
    // 以二维数组和一维数组来创建一个JTable对象
    JTable table = new JTable(tableData, columnTitle);
    // 将原表格里的model包装成新的SortTableModel对象
    SortableTableModel sorterModel = new SortableTableModel(table.getModel());

    public void init() {
        // 使用包装后的SortableTableModel对象作为JTable的model对象
        table.setModel(sorterModel);
        // 为每列的列头增加鼠标监听器
        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                // 如果单击次数小于2，即不是双击，直接返回
                if (event.getClickCount() < 2) {
                    return;
                }
                // 找出鼠标双击事件所在的索引列
                int tableColumn = table.columnAtPoint(event.getPoint());
                // 将JTable中的列索引转换成对应TableModel值的列索引
                int modelColumn = table.convertColumnIndexToModel(tableColumn);
                // 根据指定列进行排序
                sorterModel.sort(modelColumn);
            }
        });
        // 将JTable对象放在JScrollPane中，并将该JScrollPane显示出来
        jf.add(new JScrollPane(table));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new E_SortTable().init();
    }
}

class SortableTableModel extends AbstractTableModel {
    private TableModel model;
    private int sortColumn;
    private Row[] rows;

    // 将一个已经存在的TableModel对象包装成SortableTableModel对象
    public SortableTableModel(TableModel m) {
        // 将被封装的TableModel传入
        model = m;
        rows = new Row[model.getRowCount()];
        // 将原TableModel中每行记录的索引使用Row数组保存起来
        for (var i = 0; i < rows.length; i++) {
            rows[i] = new Row(i);
        }
    }

    // 实现根据指定列进行排序
    public void sort(int c) {
        sortColumn = c;
        java.util.Arrays.sort(rows);
        fireTableDataChanged();
    }

    // 下面三个方法需要访问model中的数据，所以设计本model中数据
    // 和被包装model数据中的索引转换，程序使用rows数组完成这种转换
    @Override
    public Object getValueAt(int r, int c) {
        return model.getValueAt(rows[r].index, c);
    }

    @Override
    public boolean isCellEditable(int r, int c) {
        return model.isCellEditable(rows[r].index, c);
    }

    @Override
    public void setValueAt(Object aValue, int r, int c) {
        model.setValueAt(aValue, rows[r].index, c);
    }

    // 下面方法的实现把该model的方法委托给原封装的model来实现
    @Override
    public int getRowCount() {
        return model.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return model.getColumnCount();
    }

    @Override
    public String getColumnName(int c) {
        return model.getColumnName(c);
    }

    @Override
    public Class getColumnClass(int c) {
        return model.getColumnClass(c);
    }

    // 定义一个Row类，该类用于封装JTable中的一行
    // 实际上它并不封装数据，它只封装行索引
    private class Row implements Comparable<Row> {
        // 该index保存着被封装Model里每行记录的行索引
        public int index;

        public Row(int index) {
            this.index = index;
        }

        // 实现两行之间的大小比较
        @Override
        public int compareTo(Row other) {
            Object a = model.getValueAt(index, sortColumn);
            Object b = model.getValueAt(other.index, sortColumn);
            if (a instanceof Comparable) {
                return ((Comparable) a).compareTo(b);
            } else {
                return a.toString().compareTo(b.toString());
            }
        }
        // 该index保存着被封装Model里每行记录的行索引
    }
}