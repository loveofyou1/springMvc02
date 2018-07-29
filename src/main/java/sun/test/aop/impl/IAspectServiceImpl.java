package sun.test.aop.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.test.aop.IAspectService;

/**
 * @author sunlei19
 * @create 2018/7/20
 */

@Slf4j
@Service("iAspectService")
public class IAspectServiceImpl implements IAspectService {

    @Override
    public String aspect() {
        log.info("AspectJ风格的aop实现=====================");
        return "aspectJ aop";
    }
}
