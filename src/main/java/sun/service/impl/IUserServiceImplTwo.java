package sun.service.impl;

import org.springframework.stereotype.Service;
import sun.entity.UserVO;
import sun.service.IUserService;

import java.util.List;

/**
 * @author sunlei19
 * @create 2018-06-03 19:02
 */
@Service("IUserServiceImplTwo")
public class IUserServiceImplTwo implements IUserService {
    @Override
    public String save(UserVO userVO) {
        return null;
    }

    @Override
    public UserVO queryUserInfo(String username) {
        return null;
    }

    @Override
    public UserVO queryUserInfoById(int id) {
        return null;
    }

    @Override
    public List<UserVO> queryUserLIst(UserVO userVO) {
        return null;
    }
}
