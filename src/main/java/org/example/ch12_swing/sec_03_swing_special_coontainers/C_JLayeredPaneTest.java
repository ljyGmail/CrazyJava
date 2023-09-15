package org.example.ch12_swing.sec_03_swing_special_coontainers;

import javax.swing.*;
import java.awt.*;

public class C_JLayeredPaneTest {
    JFrame jf = new JFrame("测试JLayeredPane");
    JLayeredPane layeredPane = new JLayeredPane();

    public void init() {
        // 向layeredPane中添加3个组件
        layeredPane.add(new ContentPanel(10, 20, "疯狂Java讲义", "ico/12_3/java.png"), JLayeredPane.MODAL_LAYER);
        layeredPane.add(new ContentPanel(100, 60, "疯狂Android讲义", "ico/12_3/android.png"), JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(new ContentPanel(190, 100, "轻量级Java EE企业应用实战", "ico/12_3/ee.png"), 4);
        layeredPane.setPreferredSize(new Dimension(400, 300));
        layeredPane.setVisible(true);
        jf.add(layeredPane);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new C_JLayeredPaneTest().init();
    }
}

// 扩展了JPanel类，可以直接创建一个放在指定位置
// 且有指定标题、放置指定图标的JPanel对象
class ContentPanel extends JPanel {
    public ContentPanel(int xPos, int yPos, String title, String ico) {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
        var label = new JLabel(new ImageIcon(ico));
        add(label);
        setBounds(xPos, yPos, 160, 220);
    }
}
