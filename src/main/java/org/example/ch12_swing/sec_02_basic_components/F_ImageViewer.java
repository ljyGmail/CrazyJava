package org.example.ch12_swing.sec_02_basic_components;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class F_ImageViewer {
    // 定义图片预览组件的大小
    final int PREVIEW_SIZE = 100;
    JFrame jf = new JFrame("简单图片查看器");
    JMenuBar menuBar = new JMenuBar();
    // 该label用于显示图片
    JLabel label = new JLabel();
    // 以当前路径创建文件选择器
    JFileChooser chooser = new JFileChooser(".");
    JLabel accessory = new JLabel();
    // 定义文件过滤器
    ExtensionFileFilter filter = new ExtensionFileFilter();

    public void init() {
        // ----------下面开始初始化JFileChooser的相关属性----------
        // 创建一个FileFilter
        filter.addExtension("jpg");
        filter.addExtension("jpeg");
        filter.addExtension("gif");
        filter.addExtension("png");
        filter.setDescription("图片文件(*.jpg,*.jpeg,*.gif,*.png)");
        chooser.addChoosableFileFilter(filter);
        // 禁止"文件类型"下拉列表中显示"所有文件"选项
        chooser.setAcceptAllFileFilterUsed(false);
        // 为文件选择器指定自定义的FileView
        chooser.setFileView(new FileIconView(filter));
        // 为文件选择器指定一个预览图片的附件
        chooser.setAccessory(accessory);
        // 设置预览图片组件的大小和边框
        accessory.setPreferredSize(new Dimension(PREVIEW_SIZE, PREVIEW_SIZE));
        accessory.setBorder(BorderFactory.createEtchedBorder());
        // 用于检测被选择文件的改变事件
        chooser.addPropertyChangeListener(event -> {
            // JFileChooser的被选文件已经发生了改变
            if (event.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
                // 获取用户选择的新文件
                var f = (File) event.getNewValue();
                if (f == null) {
                    accessory.setIcon(null);
                    return;
                }
                // 将所选文件读入ImageIcon对象中
                var icon = new ImageIcon(f.getPath());
                // 如果图像太大，则缩小它
                if (icon.getIconWidth() > PREVIEW_SIZE) {
                    icon = new ImageIcon(icon.getImage().getScaledInstance(PREVIEW_SIZE, -1, Image.SCALE_DEFAULT));
                }
                // 改变accessory Label的图标
                accessory.setIcon(icon);
            }
        });
        // -----下面代码开始为该窗口安装菜单-----
        var menu = new JMenu("文件");
        menuBar.add(menu);
        var openItem = new JMenuItem("打开");
        menu.add(openItem);
        // 单击openItem菜单项显示"打开文件"对话框
        openItem.addActionListener(event -> {
            // 设置文件对话框的当前路径
            // chooser.setCurrentDirectory(new File("."));
            // 显示文件对话框
            int result = chooser.showDialog(jf, "打开图片文件");
            // 如果用户选择了APPROVE(同意)按钮，即打开，保存的等效按钮
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                // 显示指定图片
                label.setIcon(new ImageIcon(name));
            }
        });
        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        // 为退出菜单绑定事件监听器
        exitItem.addActionListener(event -> System.exit(0));
        jf.setJMenuBar(menuBar);
        // 添加用于显示图片的JLabel组件
        jf.add(new JScrollPane(label));
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new F_ImageViewer().init();
    }

    // 创建FileFilter的子类，用以实现文件过滤功能
    class ExtensionFileFilter extends FileFilter {
        private String description;
        private ArrayList<String> extensions = new ArrayList<>();

        // 自定义方法，用于添加文件扩展名
        public void addExtension(String extension) {
            if (!extension.startsWith(".")) {
                extension = "." + extension;
                extensions.add(extension.toLowerCase());
            }
        }

        // 用于设置该文件过滤器的描述文本
        public void setDescription(String description) {
            this.description = description;
        }

        // 继承FileFilter类必须实现的抽象方法，返回该文件过滤器的描述文本
        public String getDescription() {
            return description;
        }

        // 继承FileFilter类必须实现的抽象方法，判断该方法过滤器是否接受该文件
        @Override
        public boolean accept(File f) {
            // 如果该文件是路径，则接受该文件
            if (f.isDirectory()) return true;
            // 将文件名转为小写(全部转为小写后比较，用于忽略文件名大小写)
            String name = f.getName().toLowerCase();
            // 遍历所有可接受的扩展名，如果扩展名相同，该文件就可接受
            for (var extension : extensions) {
                if (name.endsWith(extension)) {
                    return true;
                }
            }
            return false;
        }
    }

    // 自定义一个FileView类，用于为指定类型的文件或文件夹设置图标
    class FileIconView extends FileView {
        private FileFilter filter;

        public FileIconView(FileFilter filter) {
            this.filter = filter;
        }

        // 重写该方法，为文件夹，文件设置图标
        public Icon getIcon(File f) {
            if (!f.isDirectory() && filter.accept(f)) {
                return new ImageIcon("ico/12_2/pict.png");
            } else if (f.isDirectory()) {
                // 获取所有根路径
                File[] fList = File.listRoots();
                for (var tmp : fList) {
                    // 如果该路径是根路径
                    if (tmp.equals(f)) {
                        return new ImageIcon("ico/12_2/dsk.png");
                    }
                }
                return new ImageIcon("ico/12_2/folder.png");
            }
            // 使用默认图标
            else {
                return null;
            }
        }
    }
}
