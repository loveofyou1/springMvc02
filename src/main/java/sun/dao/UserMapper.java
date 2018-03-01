package sun.dao;

import org.springframework.stereotype.Repository;
import sun.entity.UserVO;

/**
 * @author sunlei19
 * @create 2018-02-23 17:23
 */
@Repository("uMapper")
public interface UserMapper {
    UserVO queryUserById(int id);

    UserVO queryUserByName(String userName);

    void save(UserVO userVO);
}
