package cn.gandan.test;

import cn.gandan.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class JedisTest {


    @Test
    public void test2(){
        Jedis jedis = new Jedis();
        jedis.set("username","shengli");

        String username = jedis.get("username");
        System.out.println(username);

        jedis.setex("activecode",20,"love");
    }


    @Test
    public void test3(){
        Jedis jedis = new Jedis();
        jedis.sadd("sheng","li","bao","mi","hua");
        Set<String> sheng = jedis.smembers("sheng");
        System.out.println(sheng);
    }

    @Test
    public void test4(){
        Jedis jedis = new Jedis();
        // 名称不能重复
        jedis.zadd("shengli",7,"bao");
        jedis.zadd("shengli",77,"mi");
        jedis.zadd("shengli",777,"hua");

        Set<String> shengli = jedis.zrange("shengli", 0, -1);
        System.out.println(shengli);
    }

    @Test
    public void test5(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        JedisPool localhost = new JedisPool(config, "localhost", 6379);

        Jedis jedis = localhost.getResource();

        jedis.set("lili","shengli");
        String lili = jedis.get("lili");
        System.out.println(lili);
        jedis.close();
    }

    @Test
    public void test6(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("mimi","baomihua");
        String mimi = jedis.get("mimi");
        System.out.println(mimi);
    }

}
