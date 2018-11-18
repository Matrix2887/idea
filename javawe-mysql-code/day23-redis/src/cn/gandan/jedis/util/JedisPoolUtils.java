package cn.gandan.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
    private static JedisPool jp;

    static {
        try {
            Properties prop = new Properties();
            InputStream resourceAsStream = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
            prop.load(resourceAsStream);
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
            config.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
            jp = new JedisPool(config, prop.getProperty("host"), Integer.parseInt(prop.getProperty("port")));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jedis getJedis(){
        return jp.getResource();
    }
}
