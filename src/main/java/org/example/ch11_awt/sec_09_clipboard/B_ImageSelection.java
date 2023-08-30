package org.example.ch11_awt.sec_09_clipboard;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class B_ImageSelection implements Transferable {
    private Image image;

    // 构造器，负责持有一个Image对象
    public B_ImageSelection(Image image) {
        this.image = image;
    }

    // 返回该Transferable对象所支持的所有DataFlavor
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{DataFlavor.imageFlavor};
    }

    // 返回该Transferable对象是否支持指定的DataFlavor
    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.imageFlavor);
    }

    // 取出该Transferable对象里实际的数据
    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(DataFlavor.imageFlavor)) {
            return image;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
