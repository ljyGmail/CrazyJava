package org.example.ch12_swing.sec_12_formatted_text;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.undo.UndoableEdit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class A_MonitorText {
    JFrame mainWin = new JFrame("监听Document对象");
    JTextArea target = new JTextArea(4, 35);
    JTextArea msg = new JTextArea(4, 35);
    JLabel label = new JLabel("文本域的修改信息");
    Document doc = target.getDocument();
    // 保存撤销操作的List对象
    LinkedList<UndoableEdit> undoList = new LinkedList<>();
    // 最多允许撤销多少次
    final int UNDO_COUNT = 20;

    public void init() {
        msg.setEditable(false);
        // 添加DocumentListener
        doc.addDocumentListener(new DocumentListener() {
            // 当Document的属性或属性集发生了变化时触发该方法
            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            // 当向Document中插入文本时触发该方法
            @Override
            public void insertUpdate(DocumentEvent e) {
                int offset = e.getOffset();
                int len = e.getLength();
                // 取得插入事件的位置
                msg.append("插入文本的长度: " + len + "\n");
                msg.append("插入文本的起始位置: " + offset + "\n");
                try {
                    msg.append("插入文本内容: " + doc.getText(offset, len) + "\n");
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }

            // 当从Document中删除文本时触发该方法
            @Override
            public void removeUpdate(DocumentEvent e) {
                int offset = e.getOffset();
                int len = e.getLength();
                // 取得插入事件的位置
                msg.append("删除文本的长度: " + len + "\n");
                msg.append("删除文本的起始位置: " + offset + "\n");
            }
        });

        // 添加可撤销操作的监听器
        doc.addUndoableEditListener(e -> {
            // 每次发生可撤销操作时都会触发该代码块
            UndoableEdit edit = e.getEdit();
            if (edit.canUndo() && undoList.size() < UNDO_COUNT) {
                // 将撤销操作装入List内
                undoList.add(edit);
            }
            // 已经达到了最大撤销次数
            else if (edit.canUndo() && undoList.size() >= UNDO_COUNT) {
                // 弹出第一个撤销操作
                undoList.pop();
                // 将撤销操作装入List内
                undoList.add(edit);
            }
        });
        // 为"Ctrl+Z"按键添加监听器
        target.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // 如果按键是"Ctrl+Z"
                if (e.getKeyChar() == 26) {
                    if (undoList.size() > 0) {
                        // 移出最后一个可撤销操作，并取消该操作
                        undoList.removeLast().undo();
                    }
                }
            }
        });
        var box = new Box(BoxLayout.Y_AXIS);
        box.add(new JScrollPane(target));
        var panel = new JPanel();
        panel.add(label);
        box.add(panel);
        box.add(new JScrollPane(msg));
        mainWin.add(box);
        mainWin.pack();
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new A_MonitorText().init();
    }
}
