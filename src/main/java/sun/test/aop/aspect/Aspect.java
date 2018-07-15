package sun.test.aop.aspect;


import org.aspectj.lang.JoinPoint;

/**
 * @author sunlei19
 */
public class Aspect {
    public void doBefore(JoinPoint jp) {
        System.out.println("do before");

    }
}
