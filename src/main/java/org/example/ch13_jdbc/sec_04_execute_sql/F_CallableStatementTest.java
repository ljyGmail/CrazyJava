package org.example.ch13_jdbc.sec_04_execute_sql;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Properties;

/*
Create a procedure

delimiter //
create procedure add_pro(a int, b int, out sum int)
begin
set sum = a + b;
end;
//

 */

public class F_CallableStatementTest {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String paramFile) throws Exception {
        // 使用Properties类来加载属性文件
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void callProcedure() throws Exception {
        // 加载驱动
        Class.forName(driver);
        try (
                // 获取数据库连接
                Connection conn = DriverManager.getConnection(url, user, pass);
                // 使用Connection来创建一个CallableStatement对象
                CallableStatement cstmt = conn.prepareCall("{call add_pro(?, ?, ?)}")) {
            cstmt.setInt(1, 4);
            cstmt.setInt(2, 5);
            // 注册CallableStatement的第三个参数是int类型
            cstmt.registerOutParameter(3, Types.INTEGER);
            // 执行存储过程
            cstmt.execute();
            // 获取并输出存储过程传出参数的值
            System.out.println("执行结果是: " + cstmt.getInt(3));
        }
    }

    public static void main(String[] args) throws Exception {
        var ct = new F_CallableStatementTest();
        ct.initParam("data/ch13/mysql.ini");
        ct.callProcedure();
    }
}
