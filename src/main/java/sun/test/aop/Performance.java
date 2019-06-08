package sun.test.aop;

import sun.entity.UserVO;

/**
 * 表演接口
 *
 * @author sunlei19
 * @date 2018-07-15
 */
public interface Performance {


    /**
     * 表演方法
     *
     * @return str
     */
    String perform();


    String doAround(String id);

    String queryUserList(UserVO uservo);
}
