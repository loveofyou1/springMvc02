package test;

import org.springframework.aop.framework.ProxyFactory;
import test.aopProxy.GreetingAfterAdvice;
import test.aopProxy.GreetingAroundAdvice;
import test.aopProxy.GreetingBeforeAdvice;
import test.aopProxy.GreetingBeforeAndAfterAdvice;

/**
 * @author sunlei19
 * @create 2018-06-19 16:36
 */
public class Client {
    public static void main(String[] args) {
       /* Greeting greeting = new DynamicProxy(new GreetingImpl()).getProxy();
        String user = greeting.sayHello("dean");
        System.out.println(user);*/

        /*Greeting greeting = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("Jack");*/

        ProxyFactory proxyFactory = new ProxyFactory();     // 创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());         // 射入目标类对象
       /* proxyFactory.addAdvice(new GreetingBeforeAdvice()); // 添加前置增强
        proxyFactory.addAdvice(new GreetingAfterAdvice());  // 添加后置增强*/
        // proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy(); // 从代理工厂中获取代理
        greeting.sayHello("Jack");
    }
}
