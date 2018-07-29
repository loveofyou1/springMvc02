package sun.common.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

/**
 * @author sunlei19
 * @create 2018/7/25
 */
@Slf4j
public class TestIOUtils {

    @Test
    public void testUrlToString() throws IOException {
        String str = IOUtils.toString(URI.create("http://www.baidu.com"));
        log.info("url to string:{}", str);
    }
}
