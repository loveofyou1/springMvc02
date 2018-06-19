package test;

import java.lang.reflect.Proxy;

/**
 * @author sunlei19
 * @create 2018-06-19 16:36
 */
public class Client {
    public static void main(String[] args) {
        Greeting greeting = new DynamicProxy(new GreetingImpl()).getProxy();
        greeting.sayHello("dean");
    }
}
