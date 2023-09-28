package org.example.ch12_swing.sec_10_tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class B_EditJTree {
    JFrame jf;
    JTree tree;
    // 上面JTree对象对应的model
    DefaultTreeModel model;
    // 定义几个初始节点
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    // 定义需要别拖动的TreePath
    TreePath movePath;
    JButton addSiblingButton = new JButton("添加兄弟节点");
    JButton addChildButton = new JButton("添加自节点");
    JButton deleteButton = new JButton("删除节点");
    JButton editButton = new JButton("编辑当前节点");

    public void init() {
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);
        jf = new JFrame("可编辑节点的树");
        tree = new JTree(root);
        // 获取JTree对应的TreeModel对象
        model = (DefaultTreeModel) tree.getModel();
        // 设置JTree可编辑
        tree.setEditable(true);
        MouseListener ml = new MouseAdapter() {
            // 按下鼠标时获得被拖动的节点
            @Override
            public void mousePressed(MouseEvent e) {
                // 如果需要唯一确定某个节点，则必须通过TreePath来获取
                TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                if (tp != null) {
                    movePath = tp;
                }
            }
            // 松开鼠标时获取需要拖动哪个父节点

            @Override
            public void mouseReleased(MouseEvent e) {
                // 根据松开鼠标时的TreePath来获取TreePath
                TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                if (tp != null && movePath != null) {
                    // 阻止向子节点拖动
                    if (movePath.isDescendant(tp) && movePath != tp) {
                        JOptionPane.showMessageDialog(jf, "目标节点是被移动节点的子节点，无法移动!", "非法操作", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    // 不是向子节点移动，鼠标按下、松开的也不是同一个节点
                    else if (movePath != tp) {
                        // add方法先将该节点从原父节点下删除，再添加到新父节点下
                        ((DefaultMutableTreeNode) tp.getLastPathComponent())
                                .add((DefaultMutableTreeNode) movePath
                                        .getLastPathComponent());
                        movePath = null;
                        tree.updateUI();
                    }
                }
            }
        };
        // 为JTree添加鼠标监听器
        tree.addMouseListener(ml);
        var panel = new JPanel();
        // 实现添加兄弟节点的监听器
        addSiblingButton.addActionListener(event -> {
            // 获取选中的节点
            var selectedNode = (DefaultMutableTreeNode)
                    tree.getLastSelectedPathComponent();
            // 如果节点为空，则直接返回
            if (selectedNode == null) return;
            // 获取该选中节点的父节点
            var parent = (DefaultMutableTreeNode) selectedNode.getParent();
            // 如果父节点为空，则直接返回
            if (parent == null) return;
            // 创建一个新节点
            var newNode = new DefaultMutableTreeNode("新节点");
            // 获取选中节点的选中索引
            int selectedIndex = parent.getIndex(selectedNode);
            // 在选中位置插入新节点
            model.insertNodeInto(newNode, parent, selectedIndex + 1);
            // ----------下面代码实现显示新节点(自动展开父节点)----------
            // 获取从根节点到新节点的所有节点
            TreeNode[] nodes = model.getPathToRoot(newNode);
            // 使用指定的节点数组来创建TreePath
            var path = new TreePath(nodes);
            // 显示指定的TreePath
            tree.scrollPathToVisible(path);
        });
        panel.add(addSiblingButton);

        // 实现添加子节点的监听器
        addChildButton.addActionListener(event -> {
            // 获取选中的节点
            var selectedNode = (DefaultMutableTreeNode)
                    tree.getLastSelectedPathComponent();
            // 如果节点为空，则直接返回
            if (selectedNode == null) return;
            // 创建一个新节点
            var newNode = new DefaultMutableTreeNode("新节点");
            // 通过model来添加新节点，则无须调用JTree的updateUI方法
            // model.insertNodeInto(newNode,selectedNode,selectedNode.getChildCount());
            // 通过节点添加新节点，则需要定义tree的updateUI方法
            selectedNode.add(newNode);
            // ----------下面代码实现显示新节点(自动展开父节点)----------
            TreeNode[] nodes = model.getPathToRoot(newNode);
            var path = new TreePath(nodes);
            tree.scrollPathToVisible(path);
            tree.updateUI();
        });
        panel.add(addChildButton);

        // 实现删除节点的监听器
        deleteButton.addActionListener(event -> {
            var selectedNode = (DefaultMutableTreeNode)
                    tree.getLastSelectedPathComponent();
            if (selectedNode != null && selectedNode.getParent() != null) {
                // 删除指定节点
                model.removeNodeFromParent(selectedNode);
            }
        });
        panel.add(deleteButton);

        // 实现编辑节点的监听器
        editButton.addActionListener(event -> {
            TreePath selectedPath = tree.getSelectionPath();
            if (selectedPath != null) {
                // 编辑选中的节点
                tree.startEditingAtPath(selectedPath);
            }
        });
        panel.add(editButton);
        jf.add(new JScrollPane(tree));
        jf.add(panel, BorderLayout.SOUTH);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new B_EditJTree().init();
    }
}
