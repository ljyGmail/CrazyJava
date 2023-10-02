package org.example.ch12_swing.sec_10_tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class F_CustomTreeNode {
    JFrame jf = new JFrame("定制树的节点");
    JTree tree;
    // 定义几个初始节点
    DefaultMutableTreeNode friends = new DefaultMutableTreeNode("我的好友");
    DefaultMutableTreeNode qingzhao = new DefaultMutableTreeNode("李清照");
    DefaultMutableTreeNode suge = new DefaultMutableTreeNode("苏格拉底");
    DefaultMutableTreeNode libai = new DefaultMutableTreeNode("李白");
    DefaultMutableTreeNode nongyu = new DefaultMutableTreeNode("弄玉");
    DefaultMutableTreeNode hutou = new DefaultMutableTreeNode("虎头");

    public void init() {
        // 通过add()方法建立树节点之间的父子关系
        friends.add(qingzhao);
        friends.add(suge);
        friends.add(libai);
        friends.add(nongyu);
        friends.add(hutou);
        // 以根节点创建树
        tree = new JTree(friends);
        // 设置是否显示根节点的展开/折叠图标，默认是false
        tree.setShowsRootHandles(true);
        // 设置节点是否可见，默认是false
        tree.setRootVisible(true);
        // 设置使用定制的节点绘制器
        tree.setCellRenderer(new MyImageCellRenderer());
        jf.add(new JScrollPane(tree));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new F_CustomTreeNode().init();
    }
}

class MyImageCellRenderer extends JPanel implements TreeCellRenderer {
    private ImageIcon icon;
    private String name;
    // 定义绘制单元格时的背景色
    private Color background;
    // 定义绘制单元格时的前景色
    private Color foreground;

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        icon = new ImageIcon("ico/12_10/" + value + ".gif");
        name = value.toString();
        background = hasFocus ? new Color(140, 200, 235)
                : new Color(255, 255, 255);
        foreground = hasFocus ? new Color(255, 255, 3)
                : new Color(0, 0, 0);
        // 返回该JPanel对象作为单元格绘制器
        return this;
    }

    // 重写paintComponent方法，改变JPanel的外观
    @Override
    protected void paintComponent(Graphics g) {
        int imageWidth = icon.getImage().getWidth(null);
        int imageHeight = icon.getImage().getHeight(null);
        g.setColor(background);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(foreground);
        // 绘制好友图标
        g.drawImage(icon.getImage(), getWidth() / 2 - imageWidth / 2, 10, null);
        g.setFont(new Font("SansSerif", Font.BOLD, 18));
        // 绘制好友用户名
        g.drawString(name, getWidth() / 2 - name.length() * 10, imageHeight + 30);
    }

    // 通过该方法来树则该ImageCellRenderer的最佳大小
    public Dimension getPreferredSize() {
        return new Dimension(160, 160);
    }
}