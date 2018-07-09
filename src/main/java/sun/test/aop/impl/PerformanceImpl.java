package sun.test.aop.impl;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.entity.UserVO;
import sun.service.IUserService;
import sun.test.aop.Performance;

@Service("performance")
public class PerformanceImpl implements Performance {

    private final Logger performLog = LogManager.getLogger(PerformanceImpl.class);

    @Autowired(required = false)
    private IUserService userService;

    @Override
    public void perform() {
        performLog.error("sammy perform superman. ");
        UserVO userVO = userService.queryUserInfoById(1);
        performLog.error("用户信息:{}" , JSON.toJSONString(userVO));
        performLog.error("sammy perform is end.");
    }
}
