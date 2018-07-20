package sun.test.aop.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.test.aop.IAspectService;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext-test.xml"})
public class IAspectServiceImplTest {

    @Autowired(required = false)
    private IAspectService iAspectService;


    @Test
    public void aspect() {
        iAspectService.aspect();
    }
}