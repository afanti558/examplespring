import org.junit.Test;

public class MyTest {

    //必须抛出指定异常
    @Test(expected = NullPointerException.class)
    public void testException() {
        String str = null;
        str.equals("");
    }
}
