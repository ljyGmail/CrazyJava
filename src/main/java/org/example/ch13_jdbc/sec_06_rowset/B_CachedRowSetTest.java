package org.example.ch13_jdbc.sec_06_rowset;


import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class B_CachedRowSetTest {
    private static String driver;
    private static String url;
    private static String user;
    private static String pass;

    public void initParam(String paramFile) throws Exception {
        // 使用Properties类来加载属性文件
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public CachedRowSet query(String sql) throws Exception {
        // 加载驱动
        Class.forName(driver);
        // 获取数据库连接
        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        // 使用RowSetProvider创建RowSetFactory
        RowSetFactory factory = RowSetProvider.newFactory();
        // 创建默认的CachedRowSet实例
        CachedRowSet cachedRs = factory.createCachedRowSet();
        // 使用ResultSet装填RowSet
        cachedRs.populate(rs);
        // 关闭资源
        rs.close();
        stmt.close();
        conn.close();
        return cachedRs;
    }

    public static void main(String[] args) throws Exception {
        var ct = new B_CachedRowSetTest();
        ct.initParam("data/ch13/mysql.ini");
        CachedRowSet rs = ct.query("select * from student_table");
        rs.afterLast();
        // 向前滚动结果集
        while (rs.previous()) {
            System.out.println(rs.getString(1)
                    + "\t" + rs.getString(2)
                    + "\t" + rs.getString(3));
            if (rs.getInt("student_id") == 4) {
                // 修改指定记录行
                rs.updateString("student_name", "孙悟空");
                rs.updateRow();
            }
        }
        // 重新获取数据库连接
        Connection conn = DriverManager.getConnection(url, user, pass);
        conn.setAutoCommit(false);
        // 把对RowSet所做的修改同步到底层数据库中
        rs.acceptChanges(conn);
    }
}
