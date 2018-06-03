package sun.service.impl;

import org.springframework.stereotype.Service;
import sun.entity.UserVO;
import sun.service.IUserService;

/**
 * @author sunlei19
 * @create 2018-06-03 19:02
 */
@Service("IUserServiceImplTwo")
public class IUserServiceImplTwo implements IUserService {
    public String save(UserVO userVO) {
        return null;
    }

    public UserVO queryUserInfo(String username) {
        return null;
    }

    public UserVO queryUserInfoById(int id) {
        return null;
    }
}
