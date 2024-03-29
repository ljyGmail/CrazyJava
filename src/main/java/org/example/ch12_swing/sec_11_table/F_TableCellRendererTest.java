package org.example.ch12_swing.sec_11_table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class F_TableCellRendererTest {
    JFrame jf = new JFrame("使用第一个绘制器");
    JTable table;
    // 定义二维数组作为表格数据
    Object[][] tableData = {
            new Object[]{"李清照", 29, "女", new ImageIcon("ico/12_11/3.gif"), true},
            new Object[]{"苏格拉底", 56, "男", new ImageIcon("ico/12_11/1.gif"), false},
            new Object[]{"李白", 35, "男", new ImageIcon("ico/12_11/4.gif"), true},
            new Object[]{"弄玉", 18, "女", new ImageIcon("ico/12_11/2.gif"), true},
            new Object[]{"虎头", 2, "男", new ImageIcon("ico/12_11/5.gif"), false}
    };
    // 定义一维数组作为列标题
    String[] columnTitle = {"姓名", "年龄", "性别", "主头像", "是否中国人"};

    public void init() {
        // 以二维数组和一维数组来创建一个ExtendedTableModel对象
        var model = new ExtendedTableModel(columnTitle, tableData);
        // 以ExtendedTableModel来创建JTable
        table = new JTable(model);
        table.setRowSelectionAllowed(false);
        table.setRowHeight(40);
        // 获取第三列
        TableColumn lastColumn = table.getColumnModel().getColumn(2);
        // 对第三列采用自定义的单元格绘制器
        lastColumn.setCellRenderer(new GenderTableCellRenderer());
        // 将JTable对象放在JScrollPane中，并将该JScrollPane显示出来
        jf.add(new JScrollPane(table));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new F_TableCellRendererTest().init();
    }
}

class ExtendedTableModel extends DefaultTableModel {
    // 重新提供一个构造器，该构造器的实现委托给DefaultTableModel父类
    public ExtendedTableModel(String[] columnNames, Object[][] cells) {
        super(cells, columnNames);
    }

    // 重写getColumnClass方法，根据每列的第一个值来返回其真实的数据类型
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}

// 定义自定义的第一个绘制器
class GenderTableCellRenderer extends JPanel implements TableCellRenderer {
    private String cellValue;
    // 定义图标的宽度和高度
    final int ICON_WIDTH = 23;
    final int ICON_HEIGHT = 21;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        cellValue = (String) value;
        // 数组选中状态下绘制边框
        if (hasFocus) {
            setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
        } else {
            setBorder(null);
        }
        return this;
    }

    // 重写paint()方法，负责绘制该单元格内容
    @Override
    public void paint(Graphics g) {
        // 如果表格值为”男“或"male"，则绘制一个男性图标
        if (cellValue.equalsIgnoreCase("男")
                || cellValue.equalsIgnoreCase("male")) {
            drawImage(g, new ImageIcon("ico/12_11/male.gif").getImage());
        }
        // 如果表格值为"女"或"female"，则绘制一个女性图标
        if (cellValue.equalsIgnoreCase("女")
                || cellValue.equalsIgnoreCase("female")) {
            drawImage(g, new ImageIcon("ico/12_11/female.gif").getImage());
        }
    }

    // 绘制图标的方法
    private void drawImage(Graphics g, Image image) {
        g.drawImage(image, (getWidth() - ICON_WIDTH) / 2,
                (getHeight() - ICON_HEIGHT) / 2, null);
    }
}