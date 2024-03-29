package org.example.ch15_io.sec_09_nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class D_ReadFile {
    public static void main(String[] args) throws IOException {
        try (
                // 创建文件输入流
                var fis = new FileInputStream("src/main/java/org/example/ch15_io/sec_09_nio/D_ReadFile.java");
                // 创建一个FileChannel
                FileChannel fcin = fis.getChannel()) {
            // 定义一个ByteBuffer对象，用于重复取水
            ByteBuffer bbuff = ByteBuffer.allocate(256);
            // 将FileChannel中的数据放入ByteBuffer中
            while (fcin.read(bbuff) != -1) {
                // 锁定Buffer的空白区
                bbuff.flip();
                // 创建Charset对象
                Charset charset = Charset.forName("UTF-8");
                // 创建解码器(CharsetDecoder)对象
                CharsetDecoder decoder = charset.newDecoder();
                // 将ByteBuffer的内容转码
                CharBuffer cbuff = decoder.decode(bbuff);
                System.out.print(cbuff);
                // 将Buffer初始化，为下一次读取数据做准备
                bbuff.clear();
            }
        }
    }
}
