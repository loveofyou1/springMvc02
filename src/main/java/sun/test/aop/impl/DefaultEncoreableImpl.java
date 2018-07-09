package sun.test.aop.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import sun.test.aop.Encoreable;

@Service("encoreable")
public class DefaultEncoreableImpl implements Encoreable {

    private static final Logger logger = LogManager.getLogger(DefaultEncoreableImpl.class);

    @Override
    public void performEncore() {
        logger.error("DefaultEncoreableImpl access");
    }
}
