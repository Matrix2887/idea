package cn.gandan.mybatis.sqlsession.defaults;

import cn.gandan.mybatis.cfg.Configuration;
import cn.gandan.mybatis.sqlsession.SqlSession;
import cn.gandan.mybatis.sqlsession.proxy.MapperProxy;
import cn.gandan.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    //@Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {

        // 动态代理的方法
        // 保证相同的类加载器 daoInterfaceClass.getClassLoader() = UserDao.class.getClassLoader()
        // 接口数组 new Class[]{daoInterfaceClass} 本身就是接口,直接传入接口数组中
        // 处理器 实现了了InvocationHandler接口,所以可以传入
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));
    }

    /**
     * 用于释放资源
     */
    //@Override
    public void close() {
        if(connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
