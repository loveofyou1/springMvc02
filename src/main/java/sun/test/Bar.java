package sun.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bar {
    static final Logger logger = LogManager.getLogger(Bar.class.getName());

    public boolean doIt() {
        logger.entry("BAR");
        logger.error("Did it again!");
        return logger.traceExit(false);
    }
}
