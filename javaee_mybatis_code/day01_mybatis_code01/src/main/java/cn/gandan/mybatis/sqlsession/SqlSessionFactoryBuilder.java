package cn.gandan.mybatis.sqlsession;

import cn.gandan.mybatis.cfg.Configuration;
import cn.gandan.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import cn.gandan.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *  用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config 字节输入流,这里输入的是SqlMapConfig.xml的字节流
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        // 解析xml文件,获取数据库连接参数并封装成Configuration对象
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);


        return  new DefaultSqlSessionFactory(cfg);
    }
}
