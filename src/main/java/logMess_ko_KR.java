import java.util.ListResourceBundle;

public class logMess_ko_KR extends ListResourceBundle {

    private final Object[][] myData = {
            {"debug", "디버그정보"},
            {"info", "인포정보"},
            {"error", "에러정보"},
    };

    @Override
    protected Object[][] getContents() {
        return myData;
    }
}
