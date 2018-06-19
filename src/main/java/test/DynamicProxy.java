package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sunlei19
 * @create 2018-06-19 16:33
 */
public class DynamicProxy implements InvocationHandler {

    private Object real;

    public DynamicProxy(Object _real) {
        real = _real;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(real.getClass().getClassLoader(), real.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(real, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
