import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author liruibo
 * @date 2018/7/6
 */
public class RedisTest {

    private Jedis jedis;

    @Test
    public void intResources(){
        jedis = new Jedis("192.168.1.5", 6379);
        System.out.println(jedis.asking());
    }
}
