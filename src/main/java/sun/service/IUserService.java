package sun.service;

import sun.entity.UserVO;

public interface IUserService {

    String save(UserVO userVO);

    UserVO queryUserInfo(String username);

    UserVO queryUserInfoById(int id);

}
