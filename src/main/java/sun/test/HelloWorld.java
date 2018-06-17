package sun.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {

    private static final Logger logger = LogManager.getLogger(HelloWorld.class);

    public static void main(String[] args) {

        if (logger.isDebugEnabled()) {
            logger.debug("日志输出的类名:{},日志级别是:{}", HelloWorld.class, logger.getLevel());
        }
        logger.error("hello world!");

    }
}
