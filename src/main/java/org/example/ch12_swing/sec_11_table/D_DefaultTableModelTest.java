package org.example.ch12_swing.sec_11_table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;

public class D_DefaultTableModelTest {
    JFrame mainWin = new JFrame("管理数据行、数据列");
    final int COLUMN_COUNT = 5;
    DefaultTableModel model;
    JTable table;
    // 用于保存被隐藏列的List集合
    ArrayList<TableColumn> hiddenColumns = new ArrayList<>();

    public void init() {
        model = new DefaultTableModel(COLUMN_COUNT, COLUMN_COUNT);
        for (var i = 0; i < COLUMN_COUNT; i++) {
            for (var j = 0; j < COLUMN_COUNT; j++) {
                model.setValueAt("老单元格值 " + i + " " + j, i, j);
            }
        }
        table = new JTable(model);
        mainWin.add(new JScrollPane(table), BorderLayout.CENTER);
        // 为窗口安装菜单
        var menuBar = new JMenuBar();
        mainWin.setJMenuBar(menuBar);
        var tableMenu = new JMenu("管理");
        menuBar.add(tableMenu);
        var hideColumnsItem = new JMenuItem("隐藏选中列");
        hideColumnsItem.addActionListener(event -> {
            // 获取所有选中列的索引
            int[] selected = table.getSelectedColumns();
            TableColumnModel columnModel = table.getColumnModel();
            // 依次把每一个选中的列隐藏起来，并使用List保存这些列
            for (var i = selected.length - 1; i >= 0; i--) {
                TableColumn column = columnModel.getColumn(selected[i]);
                // 隐藏指定列
                table.removeColumn(column);
                // 把隐藏的列保存起来，确保 以后可以显示出来
                hiddenColumns.add(column);
            }
        });
        tableMenu.add(hideColumnsItem);
        var showColumnsItem = new JMenuItem("显示隐藏列");
        showColumnsItem.addActionListener(event -> {
            // 把所有隐藏的列依次显示出来
            for (var tc : hiddenColumns) {
                // 依次把所有依次的列显示出来
                table.addColumn(tc);
            }
            // 清空保存依次列的List集合
            hiddenColumns.clear();
        });
        tableMenu.add(showColumnsItem);
        var addColumnItem = new JMenuItem("插入选中列");
        addColumnItem.addActionListener(event -> {
            // 获取所有选中列的索引
            int[] selected = table.getSelectedColumns();
            TableColumnModel columnModel = table.getColumnModel();
            // 依次把选中的列添加到JTable之后
            for (var i = selected.length - 1; i >= 0; i--) {
                TableColumn column = columnModel.getColumn(selected[i]);
                table.addColumn(column);
            }
        });
        tableMenu.add(addColumnItem);
        var addRowItem = new JMenuItem("增加行");
        addRowItem.addActionListener(event -> {
            // 创建一个String数组作为新增行的内容
            var newCells = new String[COLUMN_COUNT];
            for (var i = 0; i < newCells.length; i++) {
                newCells[i] = "新单元格值 " + model.getRowCount() + " " + i;
            }
            // 向TableModel中新增一行
            model.addRow(newCells);
        });
        tableMenu.add(addRowItem);
        var removeRowsItem = new JMenuItem("删除选中行");
        removeRowsItem.addActionListener(event -> {
            // 获取所有选中行
            int[] selected = table.getSelectedRows();
            // 依次删除所有选中行
            for (var i = selected.length - 1; i >= 0; i--) {
                model.removeRow(selected[i]);
            }
        });
        tableMenu.add(removeRowsItem);
        mainWin.pack();
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new D_DefaultTableModelTest().init();
    }
}
