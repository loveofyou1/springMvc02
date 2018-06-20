package test;

import org.springframework.stereotype.Component;

/**
 * @author sunlei19
 * @create 2018-06-19 16:32
 */
@Component
public class GreetingImpl implements Greeting {
    @Override
    public String sayHello(String user) {
        System.out.println("hello " + user);
        return user;
    }
}
