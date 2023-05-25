import java.util.ListResourceBundle;

public class myMess_ko_KR extends ListResourceBundle {
    // 定义资源
    private final Object myData[][] = {
            {"msg", "{0},안녕! 오늘은 {1} 입니데이~~"}
    };

    // 重写getContent()方法
    @Override
    protected Object[][] getContents() {
        // 该方法返回资源的key-value对
        return myData;
    }
}
