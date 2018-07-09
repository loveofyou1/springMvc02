package sun.test.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import sun.test.aop.Encoreable;
import sun.test.aop.impl.DefaultEncoreableImpl;

@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "sun.test.aop.Performance+",defaultImpl = DefaultEncoreableImpl.class)
    public static Encoreable encoreable;
}
