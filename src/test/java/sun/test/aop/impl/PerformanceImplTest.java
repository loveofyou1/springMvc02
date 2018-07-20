package sun.test.aop.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.test.aop.Performance;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext-test.xml"})
public class PerformanceImplTest {

    @Autowired(required = false)
    private Performance performance;


    @Test
    public void testPerform() {
        log.info("testPerform==========begin");
        performance.perform();
        log.info("testPerform==========end");
    }


    @Test
    public void testDoAround() {
        performance.doAround("1");
    }
}