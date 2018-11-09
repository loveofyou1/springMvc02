package test.redis;

import redis.clients.jedis.Jedis;

public class RedisJava {
    public static void main(String[] args) {
        Jedis jedisConn = RedisPool.getJedis();
        System.out.println(jedisConn);
        RedisPool.getJedis().set("name", "陈浩翔");
        System.out.println(RedisPool.getJedis().get("name"));
    }
}
