package sun.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Slf4j
public class Bar {
    static final Logger logger = LogManager.getLogger(Bar.class.getName());

    public boolean doIt() {
        logger.entry("BAR");
        logger.error("Did it again!");
        log.error("lombok log is good.");
        return logger.traceExit(false);
    }
}
