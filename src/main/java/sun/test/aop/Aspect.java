package sun.test.aop;


import org.aspectj.lang.JoinPoint;

public class Aspect {
    public void doBefore(JoinPoint jp) {
        System.out.println("do before");
    }
}
