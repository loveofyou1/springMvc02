package sun.common.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.junit.Test;

import java.io.File;

/**
 * 文件监听测试
 *
 * @author sunlei19
 * @create 2018/7/25
 */

@Slf4j
public class FileMonitorTest {

    @Test
    public void testMonitor() throws Exception {
        FileAlterationMonitor fileMonitor = new FileAlterationMonitor(1000);

        //设置文件过滤条件
        IOFileFilter ioFileFilter = FileFilterUtils.and(FileFilterUtils.fileFileFilter(), FileFilterUtils.nameFileFilter("mvn.txt"));
        FileAlterationObserver observer = new FileAlterationObserver(new File("d:/zk"), ioFileFilter);

        observer.addListener(new FileAlterationListenerAdaptor() {

            @Override
            public void onFileCreate(File file) {
                log.info("onFileCreate:{}", file.getName());
            }


            @Override
            public void onFileChange(File file) {
                log.info("onFileChange:{}", file.getName());
            }


            @Override
            public void onFileDelete(File file) {
                log.info("onFileDelete:{}", file.getName());
            }
        });

        fileMonitor.addObserver(observer);
        fileMonitor.start();
    }
}
