package sun.resource;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 资源文件读取方式测试类
 *
 * @author sunlei19
 * @create 2018/7/24
 */
@Slf4j
public class TestResource {

    @Test
    public void testByteArrayResource() throws IOException {
        String str = "Hello World!";
        Resource byteResource = new ByteArrayResource(str.getBytes());
        log.info(byteResource.getDescription());
        log.info(String.valueOf(byteResource.contentLength()));
        log.info(byteResource.getFilename());
        log.info(String.valueOf(((ByteArrayResource) byteResource).getByteArray()));
        if (byteResource.exists()) {
            dumpStream(byteResource);
        }
    }


    @Test
    public void testInputStreamResource() {
        ByteArrayInputStream bis = new ByteArrayInputStream("Hello World!".getBytes());
        Resource resource = new InputStreamResource(bis);
        if (resource.exists()) {
            dumpStream(resource);
        }
        Assert.assertEquals(true, resource.isOpen());
    }


    @Test
    public void testFileSystemResource() {
        File file = new File("d:/a.txt");
        Resource resource = new FileSystemResource(file);
        if (resource.exists()) {
            dumpStream(resource);
        }
        Assert.assertEquals(false, resource.isOpen());
    }


    @Test
    public void testClassPathResource() throws IOException {
        //Resource resource = new ClassPathResource("jdbc.properties");
        ClassLoader classLoader = this.getClass().getClassLoader();
        Resource resource = new ClassPathResource("jdbc.properties", classLoader);
        if (resource.exists()) {
            dumpStream(resource);
        }
        log.info("path:{}", resource.getFile().getAbsolutePath());
        log.info("classLoader:{}", ((ClassPathResource) resource).getClassLoader());
        Assert.assertEquals(false, resource.isOpen());
    }


    private void dumpStream(Resource byteResource) {
        InputStream is = null;
        try {
            //获取文件资源
            is = byteResource.getInputStream();
            //读取资源
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            log.info(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                is.close();
            } catch (Exception e) {

            }
        }
    }


}
