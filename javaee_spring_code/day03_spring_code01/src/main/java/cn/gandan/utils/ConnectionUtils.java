package cn.gandan.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接工具类,用于从数据源中获取一个连接,并且实现和线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程删多连接
     * @return
     */
    public Connection getThreadConnection(){

        try {
            Connection conn = t1.get();
            if(conn == null){
                conn = dataSource.getConnection();
                t1.set(conn);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        t1.remove();
    }

}
