package test.redis.service;

import redis.clients.jedis.Jedis;
import test.redis.domain.UserInfo;

/**
 * redis服务
 *
 * @author sunlei19
 * @create 2019/1/17
 */
public interface RedisService {

    boolean createUser(Jedis jedis, UserInfo userInfo);
}
