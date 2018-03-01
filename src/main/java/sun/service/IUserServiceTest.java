package sun.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.entity.UserVO;

/**
 * @author sunlei19
 * @create 2018-02-23 17:13
 */

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
public class IUserServiceTest {

    @Autowired
    public IUserService iUserService;

    @Test
    public void queryUser() {


        UserVO userVO = iUserService.queryUserInfo("测试");

        System.out.println(userVO.getUserName());
    }

}
