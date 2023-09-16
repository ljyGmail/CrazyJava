package org.example.ch12_swing.sec_04_simplified_drag_drop_in_swing;

import javax.swing.*;
import java.awt.*;

public class B_TransferHandlerTest {
    private JFrame jf = new JFrame("测试TransferHandler");
    JColorChooser chooser = new JColorChooser();
    JTextArea txt = new JTextArea("测试TransferHandler\n"
            + "直接将上面颜色拖入以改变文本颜色");

    public void init(){
        // 启动颜色选择器面板和文本域的拖放功能
        chooser.setDragEnabled(true);
        txt.setDragEnabled(true);
        jf.add(chooser, BorderLayout.SOUTH);
        // 允许直接将一个Color对象拖入该JTextArea对象
        // 并赋给它的foreground属性
        txt.setTransferHandler(new TransferHandler("foreground"));
        jf.add(new JScrollPane(txt));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new B_TransferHandlerTest().init();
    }
}
