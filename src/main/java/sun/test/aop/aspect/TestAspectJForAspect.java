package sun.test.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author sunlei19
 * @create 2018/7/20
 */

@Slf4j
@Aspect
public class TestAspectJForAspect {


    @Pointcut(value = "execution(* sun.test.aop.impl.IAspectServiceImpl.aspect(..))")
    public void pointForAspect() {
    }


    @Before(value = "pointForAspect()")
    public void before() {
        log.info("aspectJ切面风格的前通知before");
    }


    @After(value = "pointForAspect()")
    public void after() {
        log.info("aspectJ切面风格的后通知after");
    }


    @AfterThrowing(value = "pointForAspect()")
    public void afterThrow() {
        log.info("aspectJ切面风格的后通知afterThrow");
    }


    @AfterReturning(value = "pointForAspect()")
    public void afterReturning() {
        log.info("aspectJ切面风格的后通知afterReturning");
    }
}
