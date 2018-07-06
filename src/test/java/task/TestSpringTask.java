package task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.springTask.TaskExecutorExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext-test.xml"})
public class TestSpringTask {

    Logger logger = LogManager.getLogger(TestSpringTask.class);

    @Autowired(required = false)
    private TaskExecutorExample taskExecutorExample;

    @Test
    public void Task() {
        logger.info("测试spring任务框架开始。");
        taskExecutorExample.printMessages();
        logger.info("测试spring任务框架结束。");

    }
}
