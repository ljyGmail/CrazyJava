package org.example.ch12_swing.sec_12_formatted_text;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E_MyTextPane extends JTextPane {
    protected StyledDocument doc;
    protected SyntaxFormatter formatter = new SyntaxFormatter("data/ch12/my.stx");
    // 定义该文档的普通文本的外观属性
    private SimpleAttributeSet normalAttr = formatter.getNormalAttributeSet();
    private SimpleAttributeSet quotAttr = new SimpleAttributeSet();
    // 保存文档改变的开始位置
    private int docChangeStart = 0;
    // 保存文档改变的长度
    private int docChangeLength = 0;

    public E_MyTextPane() {
        StyleConstants.setForeground(quotAttr, new Color(255, 0, 255));
        StyleConstants.setFontSize(quotAttr, 16);
        this.doc = super.getStyledDocument();
        // 设置该文档的页边距
        this.setMargin(new Insets(3, 40, 0, 0));
        // 添加按键监听器，当按键松开时进行语法分析
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                syntaxParse();
            }
        });
        // 添加文档监听器
        doc.addDocumentListener(new DocumentListener() {
            // 当Document的属性或属性集发生了变化时触发该方法
            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            // 当向Document中插入文本是触发该方法
            @Override
            public void insertUpdate(DocumentEvent e) {
                docChangeStart = e.getOffset();
                docChangeLength = e.getLength();
            }

            // 当从Document中删除文本时触发该方法
            @Override
            public void removeUpdate(DocumentEvent e) {

            }
        });
    }

    public void syntaxParse() {
        try {
            // 获取文档的根元素，即文档内的全部内容
            Element root = doc.getDefaultRootElement();
            // 获取文档中光标插入符的位置
            int cursorPos = this.getCaretPosition();
            int line = root.getElementIndex(cursorPos);
            // 获取光标所在位置的行
            Element para = root.getElement(line);
            // 定义光标所在行的行头在文档中的位置
            int start = para.getStartOffset();
            // 让start等于start与docChangeStart中的较小值
            start = start > docChangeStart ? docChangeStart : start;
            // 定义被修改部分的长度
            int length = para.getEndOffset() - start;
            length = length < docChangeLength ? docChangeLength + 1 : length;
            // 取出所有可能被修改的字符串
            String s = doc.getText(start, length);
            // 以空格、点号等作为分隔符
            String[] tokens = s.split("\\s+|\\.|\\(|\\)|\\{|\\}|\\[|\\]");
            // 定义当前分析单词在s字符串中的开始位置
            int curStart = 0;
            // 定义单词是否处于引号内
            boolean isQuot = false;
            for (var token : tokens) {
                // 找出当前分析单词在s字符串的位置
                int tokenPos = s.indexOf(token, curStart);
                if (isQuot && (token.endsWith("\"") || token.endsWith("\'"))) {
                    doc.setCharacterAttributes(start + tokenPos, token.length(), quotAttr, false);
                    isQuot = false;
                } else if (isQuot && !(token.endsWith("\"") || token.endsWith("\'"))) {
                    doc.setCharacterAttributes(start + tokenPos, token.length(), quotAttr, false);
                } else if ((token.startsWith("\"") || token.startsWith("\'")) && (token.endsWith("\"") || token.endsWith("\'"))) {
                    doc.setCharacterAttributes(start + tokenPos, token.length(), quotAttr, false);
                } else if ((token.startsWith("\"") || token.startsWith("\'")) && !(token.endsWith("\"") || token.endsWith("\'"))) {
                    doc.setCharacterAttributes(start + tokenPos, token.length(), quotAttr, false);
                    isQuot = true;
                } else {
                    // 使用格式器对当前单词设置颜色
                    formatter.setHighLight(doc, token, start + tokenPos, token.length());
                }
                // 开始分析下一个单词
                curStart = tokenPos + token.length();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 重画该组件，设置行号
    public void paint(Graphics g) {
        super.paint(g);
        Element root = doc.getDefaultRootElement();
        // 获得行号
        int line = root.getElementIndex(doc.getLength());
        // 设置颜色
        g.setColor(new Color(230, 230, 230));
        // 绘制显示行数的矩形框
        g.fillRect(0, 0, this.getMargin().left - 10, getSize().height);
        // 设置行号的颜色
        g.setColor(new Color(40, 40, 40));
        // 每行绘制一个行号
        for (int count = 0, j = 1; count <= line; count++, j++) {
            g.drawString(String.valueOf(j), 3, (int) ((count + 1) * 1.535 * StyleConstants.getFontSize(normalAttr)));
        }
    }

    public static void main(String[] args) {
        var frame = new JFrame("文本编辑器");
        // 使用MyTextPane
        frame.getContentPane().add(new JScrollPane(new E_MyTextPane()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final var inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2);
        frame.setVisible(true);
    }
}

// 定义语法格式器
class SyntaxFormatter {
    // 以一个Map保存关键字和颜色的对应关系
    private Map<SimpleAttributeSet, ArrayList<String>> attMap = new HashMap<>();
    // 定义文档的正常文本的外观属性
    SimpleAttributeSet normalAttr = new SimpleAttributeSet();

    public SyntaxFormatter(String syntaxFile) {
        // 设置正常文本的颜色、大小
        StyleConstants.setForeground(normalAttr, Color.BLACK);
        StyleConstants.setFontSize(normalAttr, 16);
        // 创建一个Scanner对象，负责根据语法文件加载颜色信息
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(syntaxFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("丢失语法文件: " + e.getMessage());
        }
        var color = -1;
        ArrayList<String> keywords = new ArrayList<>();
        // 不断读取语法文件的内容行
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // 如果当前行以#开头
            if (line.startsWith("#")) {
                if (keywords.size() > 0 && color > -1) {
                    // 取出当前行的颜色值 ，并封装成SimpleAttributeSet对象
                    var att = new SimpleAttributeSet();
                    StyleConstants.setForeground(att, new Color(color));
                    StyleConstants.setFontSize(att, 16);
                    // 将当前颜色和关键字List对应起来
                    attMap.put(att, keywords);
                }
                // 重新创建新的关键字List，为下一个语法格式做准备
                keywords = new ArrayList<>();
                color = Integer.parseInt(line.substring(1), 16);
            } else {
                // 对于普通行，将每行内容添加到关键字List里
                if (line.trim().length() > 0) {
                    keywords.add(line.trim());
                }
            }
        }
        // 把 所有的关键字和颜色对应起来
        if (keywords.size() > 0 && color > -1) {
            var att = new SimpleAttributeSet();
            StyleConstants.setForeground(att, new Color(color));
            StyleConstants.setFontSize(att, 16);
            attMap.put(att, keywords);
        }
    }

    // 返回该格式器里正常文本的外观属性
    public SimpleAttributeSet getNormalAttributeSet() {
        return normalAttr;
    }

    // 设置语法高亮
    public void setHighLight(StyledDocument doc, String token, int start, int length) {
        // 保存当前单词对应的外观属性
        SimpleAttributeSet currentAttributeSet = null;
        outer:
        for (var att : attMap.keySet()) {
            // 取出当前颜色对应的所有关键字
            ArrayList<String> keywords = attMap.get(att);
            // 遍历所有关键字
            for (var keyword : keywords) {
                // 如果该关键字与当前单词相同
                if (keyword.equals(token)) {
                    // 跳出循环，并设置当前单词对应的外观属性
                    currentAttributeSet = att;
                    break outer;
                }
            }
        }
        // 如果当前单词对应的外观属性不为空
        if (currentAttributeSet != null) {
            // 设置当前单词的颜色
            doc.setCharacterAttributes(start, length, currentAttributeSet, false);
        }
        // 否则使用普通外观来设置该单词
        else {
            doc.setCharacterAttributes(start, length, normalAttr, false);
        }
    }
}