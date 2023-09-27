package org.example.ch12_swing.sec_10_tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class A_SimpleJTree {
    JFrame jf = new JFrame("简单树");
    JTree tree;
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode guangdong;
    DefaultMutableTreeNode guangxi;
    DefaultMutableTreeNode foshan;
    DefaultMutableTreeNode shantou;
    DefaultMutableTreeNode guilin;
    DefaultMutableTreeNode nanning;

    public void init() {
        // 依此创建树中的所有节点
        root = new DefaultMutableTreeNode("中国");
        guangdong = new DefaultMutableTreeNode("广东");
        guangxi = new DefaultMutableTreeNode("广西");
        foshan = new DefaultMutableTreeNode("佛山");
        shantou = new DefaultMutableTreeNode("汕头");
        guilin = new DefaultMutableTreeNode("桂林");
        nanning = new DefaultMutableTreeNode("南宁");

        // 通过add()方法建立树节点之间的父子关系
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);
        // 以根节点创建树
        tree = new JTree(root);
        // 没有连接线
        // tree.putClientProperty("JTree.lineStyle", "None");
        // 水平分割线
        // tree.putClientProperty("JTree.lineStyle", "Horizontal");
        // 设置是否显示根节点的"展开、折叠"图标，默认是false
        // tree.setShowsRootHandles(true);
        // 设置根节点是否可见，默认是true
        tree.setRootVisible(false);
        jf.add(new JScrollPane(tree));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new A_SimpleJTree().init();
    }
}
