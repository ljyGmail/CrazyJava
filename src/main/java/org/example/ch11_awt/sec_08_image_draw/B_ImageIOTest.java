package org.example.ch11_awt.sec_08_image_draw;

import javax.imageio.ImageIO;

public class B_ImageIOTest {
    public static void main(String[] args) {
        String[] readFormat = ImageIO.getReaderFormatNames();
        System.out.println("-----Image能读的所有图形文件格式-----");
        for (var tmp : readFormat) {
            System.out.println(tmp);
        }

        String[] writeFormat = ImageIO.getWriterFormatNames();
        System.out.println("-----Image能写的所有图形文件格式-----");
        for (var tmp : writeFormat) {
            System.out.println(tmp);
        }
    }
}
