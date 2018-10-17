package redis;


import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRedis {

    private static final Logger redisLog = LogManager.getLogger(TestRedis.class);

    private Jedis jedis;

    @Before
    public void setJedis() {
        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
        //jedis.auth("sunlei");
        redisLog.info("连接服务成功");
    }


    //@Test
    public void testString() {
        //设置字符串
        jedis.set("1", "one");
        redisLog.info("拼接前：{}", jedis.get("1"));

        //给“1”后面拼接字符
        jedis.append("1", " is the first!");
        redisLog.info("拼接后：{}", jedis.get("1"));

        //删除某个键值对
        jedis.del("1");
        redisLog.info("删除后：{}", jedis.get("1"));

        //设置多个键值对
        jedis.mset("2", "two", "3", "three", "4", "four", "age", "20");
        jedis.incr("age");
        redisLog.info("设置多个键值对后：{}", jedis.mget("2", "3", "4", "age"));
    }

    @Test
    public void testMap() {
        //添加数据
        Map<String, String> map = new HashMap<>();
        map.put("name", "sunlei");
        map.put("age", "20");
        map.put("email", "sunlei19@jd.com");
        map.put("address", "hebei");
        jedis.hmset("user", map);

        //取出user中得name，结果是一个泛型得List
        List<String> list = jedis.hmget("user", "name", "age", "email", "address");
        redisLog.info("数据信息：{}", JSON.toJSONString(list));
    }

    /**
     * jedis操作List
     */
    //@Test
    public void testList() {
        //移除javaFramwork所所有内容
        jedis.del("javaFramwork");
        //存放数据
        jedis.lpush("javaFramework", "spring");
        jedis.lpush("javaFramework", "springMVC");
        jedis.lpush("javaFramework", "mybatis");
        //取出所有数据,jedis.lrange是按范围取出
        //第一个是key，第二个是起始位置，第三个是结束位置
        redisLog.info("长度:" + jedis.llen("javaFramework"));
        //jedis.llen获取长度，-1表示取得所有
        redisLog.info("javaFramework:" + jedis.lrange("javaFramework", 0, -1));

        jedis.del("javaFramework");
        redisLog.info("删除后长度:" + jedis.llen("javaFramework"));
        redisLog.info(jedis.lrange("javaFramework", 0, -1));
    }

    /**
     * jedis操作Set
     */
    //@Test
    public void testSet() {
        //添加
/*        jedis.sadd("user", "chenhaoxiang");
        jedis.sadd("user", "hu");
        jedis.sadd("user", "chen");
        jedis.sadd("user", "xiyu");
        jedis.sadd("user", "chx");
        jedis.sadd("user", "are");
        //移除user集合中的元素are
        jedis.srem("user", "are");*/
        jedis.sadd("hello", "sunlei");
        redisLog.info("hello:" + jedis.smembers("hello"));//获取所有加入user的value
        redisLog.info("chx是否是hello中的元素:" + jedis.sismember("hello", "chx"));//判断chx是否是user集合中的元素
        redisLog.info("hello中元素的个数:" + jedis.scard("hello"));
    }

    /**
     * 排序
     */
    //@Test
    public void test() {
        jedis.del("number");//先删除数据，再进行测试
        jedis.rpush("number", "4");//将一个或多个值插入到列表的尾部(最右边)
        jedis.rpush("number", "5");
        jedis.rpush("number", "3");

        jedis.lpush("number", "9");//将一个或多个值插入到列表头部
        jedis.lpush("number", "1");
        jedis.lpush("number", "2");
        redisLog.info(jedis.lrange("number", 0, jedis.llen("number")));
        redisLog.info("排序:" + jedis.sort("number"));
        redisLog.info(jedis.lrange("number", 0, -1));//不改变原来的排序
        jedis.del("number");//测试完删除数据
        redisLog.info(jedis.llen("number"));
    }

}
