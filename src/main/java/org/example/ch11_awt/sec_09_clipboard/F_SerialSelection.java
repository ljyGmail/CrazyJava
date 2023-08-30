package org.example.ch11_awt.sec_09_clipboard;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;

public class F_SerialSelection implements Transferable {
    // 持有一个可序列化的对象
    private Serializable obj;

    // 创建该类的对象时传入被持有的对象
    public F_SerialSelection(Serializable obj) {
        this.obj = obj;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        var flavors = new DataFlavor[2];
        // 获取被封装对象的类型
        Class clazz = obj.getClass();
        try {
            flavors[0] = new DataFlavor(DataFlavor.javaSerializedObjectMimeType + ";class=" + clazz.getName());
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
                        && flavor.getSubType().equals("x-java-serialized-object")
                        && flavor.getRepresentationClass().isAssignableFrom(obj.getClass());
    }

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
