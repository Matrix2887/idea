package cn.gandan.mybatis.sqlsession.proxy;

import cn.gandan.mybatis.cfg.Mapper;
import cn.gandan.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class MapperProxy implements InvocationHandler {

    //map的key是全限定类名+方法名
    private Map<String,Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 用于对方法进行增强的，我们的增强其实就是调用selectList方法
     * @param proxy 代理对象
     * @param method 方法
     * @param args 参数
     * @return
     * @throws Throwable
     */
    //@Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        //2.获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className+"."+methodName;
        //4.获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        //5.判断是否有mapper
        if(mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //6.调用工具类执行查询所有
        // 链式编程调用selectList方法
        return new Executor().selectList(mapper,conn);
    }
}
