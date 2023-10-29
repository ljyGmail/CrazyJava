package org.example.ch13_jdbc.sec_07_transaction;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class A_TransactionTest {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String paramFile) throws Exception {
        // 使用Properties类来加载属性文件
        var props = new Properties();
        props.load(new FileInputStream("data/ch13/mysql.ini"));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void insertInTrasaction(String[] sqls) throws Exception {
        // 加载驱动
        Class.forName(driver);
        try (
                Connection conn = DriverManager.getConnection(url, user, pass)) {
            // 关闭自动提交，开启事务
            conn.setAutoCommit(false);
            try (
                    // 使用Connection来创建一个Statement对象
                    Statement stmt = conn.createStatement()) {
                // 循环多次执行SQL语句
                for (var sql : sqls) {
                    stmt.executeUpdate(sql);
                }
            }
            // 提交事务
            conn.commit();
        }
    }

    public static void main(String[] args) throws Exception {
        var tt = new A_TransactionTest();
        tt.initParam("data/ch13/mysql.ini");
        var sqls = new String[]{
                "insert into student_table values(null, 'aaa', 1)",
                "insert into student_table values(null, 'bbb', 1)",
                "insert into student_table values(null, 'ccc', 1)",
                // 下面这条SQL语句将会违反外键约束
                // 因为teacher_table表中没有ID为5的记录。
                "insert into student_table values(null, 'ddd', 5)",
        };
        tt.insertInTrasaction(sqls);
    }
}
