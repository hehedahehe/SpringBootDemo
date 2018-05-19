import org.junit.Test;

import java.util.Calendar;

/*
 * @desc
 * @author lirb
 * @datetime 2018/5/16,12:09
 */
public class CalenderTest {

    @Test
    public void testCalendar(){
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH)+1);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }
}
