package redis;

import com.jd.jim.cli.Cluster;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author sunlei19
 * @create 2019/1/28
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-test.xml"})
public class JimDbTest {
    @Resource(name = "jimClient")
    private Cluster jimClient;

    public String getByKey(String key) {
        return jimClient.get(key);
    }

    public void setKey(String key, String value) {
        jimClient.set(key, value);
    }

    @Test
    public void testJimDb() {
        String key = "sunlei";
        String value = "nihao";
        setKey(key, value);
        System.out.println(getByKey(key));
    }
}
