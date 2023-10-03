package org.example.ch12_swing.sec_11_table;

import javax.swing.*;

public class A_SimpleTable {
    JFrame jf = new JFrame("简单表格");
    JTable table;
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

    public void init() {
        // 以二维数组和一维数组来创建一个JTable对象
        table = new JTable(tableData, columnTitle);
        // 将JTable对象放在JScrollPane中
        jf.add(new JScrollPane(table));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new A_SimpleTable().init();
    }
}
