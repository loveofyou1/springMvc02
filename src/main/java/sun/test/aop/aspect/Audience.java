package sun.test.aop.aspect;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Audience {

    private static final Logger logger = LogManager.getLogger(Audience.class);

    /**
     * 定义一个切点
     */
    @Pointcut("execution(* sun.test.aop.Performance.perform(..))")
    private void performance() {
    }

    @Before("performance()")
    public void silenceCellphone() {
        logger.error("Silencing Cellphone");
    }

    @Before("performance()")
    public void takeSeats() {
        logger.error("take seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        logger.error("audience applause");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        logger.error("audience demand refund.");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint ) {
        try{
            logger.error(" audience watchPerformance");
            joinPoint.proceed();
        } catch (Throwable throwable) {
           logger.error("demand refund：{}",JSON.toJSONString(throwable));
        }
    }
}
