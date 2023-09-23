package org.example.ch12_swing.sec_09_list_combobox;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class A_ListTest {
    private JFrame mainWin = new JFrame("测试列表框");
    String[] books = new String[]{
            "疯狂Java讲义",
            "轻量级Java EE企业应用实战",
            "疯狂Android讲义",
            "疯狂Ajax讲义",
            "经典Java EE企业应用实战"
    };
    // 用一个字符串数组来创建一个JList对象
    JList<String> bookList = new JList<>(books);
    JComboBox<String> bookSelector;
    // 定义布局选择按钮所在的面板
    JPanel layoutPanel = new JPanel();
    ButtonGroup layoutGroup = new ButtonGroup();
    // 定义选择模式按钮所在的面板
    JPanel selectModelPanel = new JPanel();
    ButtonGroup selectModeGroup = new ButtonGroup();
    JTextArea favorite = new JTextArea(4, 40);

    public void init() {
        // 设置JList的可视高度可同时显示3个列表项
        bookList.setVisibleRowCount(3);
        // 默认选中第3项到第5项(第1项的索引是0)
        bookList.setSelectionInterval(2, 4);
        addLayoutButton("纵向滚动", JList.VERTICAL);
        addLayoutButton("纵向换行", JList.VERTICAL_WRAP);
        addLayoutButton("横向换行", JList.HORIZONTAL_WRAP);
        addSelectModeButton("无限制", ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        addSelectModeButton("单选", ListSelectionModel.SINGLE_SELECTION);
        addSelectModeButton("单范围", ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        var listBox = new Box(BoxLayout.Y_AXIS);
        // 将JList组件放在JScrollPane中，再将该JScrollPane添加到listBox容器中
        listBox.add(new JScrollPane(bookList));
        // 添加布局选择按钮面板、选择模式按钮面板
        listBox.add(layoutPanel);
        listBox.add(selectModelPanel);
        // 为JList添加事件监听器
        bookList.addListSelectionListener(e -> {
            // 获取用户所选择的所有图书
            List<String> books = bookList.getSelectedValuesList();
            favorite.setText("");
            for (var book : books) {
                favorite.append(book + "\n");
            }
        });
        Vector<String> bookCollection = new Vector<>();
        bookCollection.add("疯狂Java讲义");
        bookCollection.add("轻量级Java EE企业应用实战");
        bookCollection.add("疯狂Android讲义");
        bookCollection.add("疯狂Ajax讲义");
        bookCollection.add("经典Java EE企业应用实战");
        // 用一个Vector对象来创建一个JComboBox对象
        bookSelector = new JComboBox<>(bookCollection);
        // 为JComboBox添加事件监听器
        bookSelector.addItemListener(e -> {
            // 获取JComboBox所选中的项
            Object book = bookSelector.getSelectedItem();
            favorite.setText(book.toString());
        });
        // 设置可以直接编辑
        bookSelector.setEditable(true);
        // 设置下拉列表框的可视高度可同时显示4个列表项
        bookSelector.setMaximumRowCount(4);
        var p = new JPanel();
        p.add(bookSelector);
        var box = new Box(BoxLayout.X_AXIS);
        box.add(listBox);
        box.add(p);
        mainWin.add(box);
        var favoritePanel = new JPanel();
        favoritePanel.setLayout(new BorderLayout());
        favoritePanel.add(new JScrollPane(favorite));
        favoritePanel.add(new JLabel("您喜欢的图书: "), BorderLayout.NORTH);
        mainWin.add(favoritePanel, BorderLayout.SOUTH);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    private void addLayoutButton(String label, final int orientation) {
        layoutPanel.setBorder(new TitledBorder(new EtchedBorder(), "确定选项布局"));
        var button = new JRadioButton(label);
        // 把该单选按钮添加到layoutPanel面板中
        layoutPanel.add(button);
        // 默认选中第一个按钮
        if (layoutGroup.getButtonCount() == 0)
            button.setSelected(true);
        layoutGroup.add(button);
        button.addActionListener(event ->
                // 改变列表框里列表项的布局方向
                bookList.setLayoutOrientation(orientation));
    }

    private void addSelectModeButton(String label, final int selectModel) {
        selectModelPanel.setBorder(new TitledBorder(new EtchedBorder(), "确定选择模式"));
        var button = new JRadioButton(label);
        // 把该单选按钮添加到selectModelPanel面板中
        selectModelPanel.add(button);
        // 默认选择第一个按钮
        if (selectModeGroup.getButtonCount() == 0)
            button.setSelected(true);
        selectModeGroup.add(button);
        button.addActionListener(event ->
                // 改变列表框里的选择模式
                bookList.setSelectionMode(selectModel));
    }

    public static void main(String[] args) {
        new A_ListTest().init();
    }
}
