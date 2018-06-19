package test;

/**
 * @author sunlei19
 * @create 2018-06-19 16:32
 */
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String user) {
        System.out.println("hello " + user);
    }
}
