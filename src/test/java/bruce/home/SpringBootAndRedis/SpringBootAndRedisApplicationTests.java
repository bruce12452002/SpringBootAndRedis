package bruce.home.SpringBootAndRedis;

import bruce.home.SpringBootAndRedis.config.IGlobalCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
class SpringBootAndRedisApplicationTests {

    @Autowired
    private IGlobalCache globalCache;

    @Test
    public void test() {
        globalCache.set("key", "value");
        globalCache.lSetAll("list", Arrays.asList("hello", "redis"));
        List<Object> list = globalCache.lGet("list", 0, -1);
        System.out.println(globalCache.get("key"));
        System.out.println(list);
    }
}
