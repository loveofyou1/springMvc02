package test.redis.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import test.redis.domain.UserInfo;

import java.util.Date;
import java.util.Map;

/**
 * @author sunlei19
 * @create 2019/1/17
 */
@Slf4j
public class RedisServiceImpl implements RedisService {
    @Override
    public boolean createUser(Jedis jedis, UserInfo userInfo) {
        String login = userInfo.getLogin();
        String users = "users:";
        if (jedis.hexists(users,login)) {
            log.info("key has exist");
            return false;
        }
        Long id = jedis.hincrBy(users,"id",1);
        if (id <= 0) {
            id = 1L;
        }
        jedis.hset("users:", login, id.toString());
        Map<String, String> userMap = Maps.newHashMap();
        userMap.put("login", login);
        userMap.put("id", String.valueOf(id));
        userMap.put("name", userInfo.getName());
        userMap.put("followers", userInfo.getFollowers());
        userMap.put("following", userInfo.getFollowing());
        userMap.put("posts", userInfo.getPosts());
        userMap.put("signUp", String.valueOf(new Date()));
        try {
            String result = jedis.hmset("users:" + id, userMap);
            if ("OK".equals(result)) {
                log.info("新增用户信息：{}", JSON.toJSONString(userMap));
                return true;
            }
        } catch (Exception e) {
            log.error("新增用户失败:{}", e);
        }
        return false;
    }
}
