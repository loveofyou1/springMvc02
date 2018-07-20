package sun.test.aop.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author sunlei19
 */
@Slf4j
public class Aspect {
    public void doBefore(JoinPoint jp) {
        log.info("do before");

    }


    public void doAfter(JoinPoint joinPoint) {
        log.info("do After");
    }


    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        log.info("===========around before advice");
        /**new Object[]{"2"} 替换掉被切面方法里的参数 */
        Object retVal = pjp.proceed(new Object[]{"2"});
        log.info("===========around after advice");
        return retVal;
    }
}
