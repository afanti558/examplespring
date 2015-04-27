import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * Created by xiaofan on 2015/4/26.
 */
@RunWith(Parameterized.class)
public class ParameterTest {
    private SimpleDateFormat simpleDateFormat;
    private String date;
    private String dateformat;
    private String expectedDate;

    public ParameterTest(String date, String dateformat, String expectedDate) {
        this.date = date;
        this.dateformat = dateformat;
        this.expectedDate = expectedDate;
    }

    @Parameterized.Parameters
    @SuppressWarnings("unchecked")
    public static Collection getParameters() {
        String[][] object = {
                {"2011-07-01 00:30:59","yyyyMMdd","20110701"},
                {"2011-07-01 00:30:59","yyyy年MM月dd日","2011年07月01日"},
                {"2011-07-01 00:30:59","HH时mm分ss秒","00时30分59秒"}
        };
                return Arrays.asList(object);
    }

    @Test
    public void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(this.date);
        simpleDateFormat = new SimpleDateFormat(this.dateformat);
        String result = simpleDateFormat.format(d);
        System.out.println(this.expectedDate.equals(result));
        
    }
}
