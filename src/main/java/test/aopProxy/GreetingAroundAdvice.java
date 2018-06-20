package test.aopProxy;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class GreetingAroundAdvice implements org.aopalliance.intercept.MethodInterceptor {

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        Object result = invocation.proceed();
        after();
        return result;
    }
}
