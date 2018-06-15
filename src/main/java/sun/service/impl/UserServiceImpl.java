package sun.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import sun.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.entity.UserVO;
import sun.service.IUserService;

import javax.annotation.Resource;

/**
 * @author sunlei19
 * @create 2018-02-23 16:36
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper uMapper;

    @Override
    public String save(UserVO userVO) {
        if (userVO != null) {
            UserVO tempVo = uMapper.queryUserByName(userVO.getUserName());
            if (tempVo != null && tempVo.getUserName().equals(userVO.getUserName())) {
                return "user had existed!";
            } else {
                uMapper.save(userVO);
                return "showName";
            }
        }
        return "error";
    }

    @Override
    public UserVO queryUserInfo(String username) {

        return uMapper.queryUserByName(username);
    }

    @Override
    public UserVO queryUserInfoById(int id) {
        return uMapper.queryUserById(id);
    }
}
