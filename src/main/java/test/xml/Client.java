package test.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.Greeting;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("conf/spring-aop.xml");
        Greeting greeting = (Greeting) applicationContext.getBean("greetingProxy");
        greeting.sayHello("sammy");
    }
}
