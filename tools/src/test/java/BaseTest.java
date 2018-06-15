import org.junit.Test;

import java.util.UUID;

/*
 * @desc
 * @author lirb
 * @datetime 2018/5/19,10:49
 */
public class BaseTest {

    @Test
    public void testPrimitive(){
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }
}
