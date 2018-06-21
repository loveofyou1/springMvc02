package sun.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.entity.UserVO;
import sun.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext-test.xml"})
public class UserServiceImplTest {

    private static final Logger testLog = LogManager.getLogger(UserServiceImplTest.class);

    @Autowired
    private IUserService userService;

    @Before
    public void init() {
        testLog.info("测试接口开始===========");
    }

    @Test
    public void queryUserInfo() {
        testLog.info("测试根据用户名查询信息");
        String jsonStr = "{\"1\":\"one\",\"2\":\"two\"}";
        UserVO userVO = userService.queryUserInfo("12");
        testLog.info("查询结果：{},{}", JSON.toJSONString(userVO), jsonStr);
    }

    @Test
    public void queryUserInfoById(){
        testLog.info("测试根据用户id查询用户信息");
        Assert.assertEquals("用户不存在",12, 12);
        UserVO userVO = userService.queryUserInfoById(12);
        testLog.info("根据用户id查询结果：{}", JSON.toJSONString(userVO));
    }

    @After
    public void end() {
        testLog.info("测试接口结束-----------");
    }

    @BeforeClass
    public static void beforeClass() {
        testLog.info("类执行前运行");
    }


    @AfterClass
    public static void afterClass() {
        testLog.info("类执行完成后，最后执行");
    }
}