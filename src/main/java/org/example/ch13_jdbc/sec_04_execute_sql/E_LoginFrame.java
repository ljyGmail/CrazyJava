package org.example.ch13_jdbc.sec_04_execute_sql;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class E_LoginFrame {
    private final String PROP_FILE = "data/ch13/mysql.ini";
    private String driver;
    // url是数据库的服务地址
    private String url;
    private String user;
    private String pass;
    // 登录界面的GUI组件
    private JFrame jf = new JFrame("登录");
    private JTextField userField = new JTextField(20);
    private JTextField passField = new JTextField(20);
    private JButton loginButton = new JButton("登录");

    public void init() throws Exception {
        var connProp = new Properties();
        connProp.load(new FileInputStream(PROP_FILE));
        driver = connProp.getProperty("driver");
        url = connProp.getProperty("url");
        user = connProp.getProperty("user");
        pass = connProp.getProperty("pass");
        // 加载驱动
        Class.forName(driver);
        // 为登录按钮添加事件监听器
        loginButton.addActionListener(e -> {
            // 登录成功则显示"登录成功"
            if (validatePrepare(userField.getText(), passField.getText())) {
                JOptionPane.showMessageDialog(jf, "登录成功");
            }
            // 否则显示"登录失败"
            else {
                JOptionPane.showMessageDialog(jf, "登录失败");
            }
        });
        jf.add(userField, BorderLayout.NORTH);
        jf.add(passField);
        jf.add(loginButton, BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
    }

    private boolean validate(String userName, String userPass) {
        // 执行查询的SQL语句
        var sql = "select * from jdbc_test"
                + " where jdbc_name = '" + userName
                + "' and jdbc_desc = '" + userPass + "'";
        System.out.println(sql);
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // 如果查询的ResultSet里有超过一条的记录，则登录成功
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean validatePrepare(String userName, String userPass) {
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement pstmt = conn.prepareStatement("select * from jdbc_test where jdbc_name = ? and jdbc_desc = ?")) {
            pstmt.setString(1, userName);
            pstmt.setString(2, userPass);
            try (
                    ResultSet rs = pstmt.executeQuery()
            ) {
                // 如果查询的ResultSet里有超过一条的记录，则登录成功
                if (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new E_LoginFrame().init();
    }
}
