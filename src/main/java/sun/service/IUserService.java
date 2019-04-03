package sun.service;

import sun.entity.UserVO;

import java.util.List;

public interface IUserService {

    String save(UserVO userVO);

    UserVO queryUserInfo(String username);

    UserVO queryUserInfoById(int id);

    List<UserVO> queryUserLIst(UserVO userVO);
}
