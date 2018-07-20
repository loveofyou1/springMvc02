package sun.test.aop.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.entity.UserVO;
import sun.service.IUserService;
import sun.test.aop.Performance;

/**
 * @author sunlei19
 */
@Slf4j
@Service("performance")
public class PerformanceImpl implements Performance {


    @Autowired(required = false)
    private IUserService userService;


    @Override
    public String perform() {
        log.error("sammy perform superman. ");
        UserVO userVO = userService.queryUserInfoById(1);
        log.error("用户信息:{}", JSON.toJSONString(userVO));
        log.error("sammy perform is end.");
        return JSON.toJSONString(userVO);
    }


    @Override
    public String doAround(String id) {
        log.info("doAround ===============begin");
        log.info("doAround params={}", id);
        UserVO userVO = userService.queryUserInfoById(Integer.valueOf(id));
        log.info("用户信息：{}", JSON.toJSONString(userVO));
        log.info("doAround ===============end");
        return JSON.toJSONString(userVO);
    }
}
