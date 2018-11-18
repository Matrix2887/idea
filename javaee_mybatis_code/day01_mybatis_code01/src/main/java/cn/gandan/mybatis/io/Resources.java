package cn.gandan.mybatis.io;

import java.io.InputStream;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * 使用类加载器读取配置文件的类
 */
public class Resources {

    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        // 利用类加载器读取资源文件
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
