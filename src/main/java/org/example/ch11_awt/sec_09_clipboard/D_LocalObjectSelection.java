package org.example.ch11_awt.sec_09_clipboard;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class D_LocalObjectSelection implements Transferable {
    // 持有一个对象的引用
    private Object obj;

    public D_LocalObjectSelection(Object obj) {
        this.obj = obj;
    }

    // 返回该Transferable对象支持的DataFlavor
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        var flavors = new DataFlavor[2];
        // 获取被封装对象的类型
        Class clazz = obj.getClass();
        String mimeType = "application/x-java-jvm-local-objectref;"
                + "class=" + clazz.getName();
        try {
            flavors[0] = new DataFlavor(mimeType);
            flavors[1] = DataFlavor.stringFlavor;
            return flavors;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.stringFlavor) ||
                flavor.getPrimaryType().equals("application")
                        && flavor.getSubType().equals("x-java-jvm-local-objectref")
                        && flavor.getRepresentationClass().isAssignableFrom(obj.getClass());
    }

    // 取出该Transferable对象封装的数据
    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (!isDataFlavorSupported(flavor)) {
            throw new UnsupportedFlavorException(flavor);
        }
        if (flavor.equals(DataFlavor.stringFlavor)) {
            return obj.toString();
        }
        return obj;
    }
}
