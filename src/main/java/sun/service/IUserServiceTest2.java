package sun.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.dao.UserMapper;
import sun.entity.UserVO;

public class IUserServiceTest2 {


    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService uService = (IUserService) application.getBean("userService");
        UserMapper userMapper = (UserMapper) application.getBean("userMapper");
        System.out.println(userMapper);
        UserVO user = uService.queryUserInfo("测试");
        System.out.println(user.getUserName());
    }
}