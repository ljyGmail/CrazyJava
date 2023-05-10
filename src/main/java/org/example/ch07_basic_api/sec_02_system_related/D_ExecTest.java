package org.example.ch07_basic_api.sec_02_system_related;

public class D_ExecTest {
    public static void main(String[] args) throws Exception {
        var rt = Runtime.getRuntime();
        // 运行记事本程序
        rt.exec("notepad.exe");
    }
}
