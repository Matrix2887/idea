package cn.gandan.factory;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Bean:可重用组件
 *
 * JavaBean:用java语言编写的可重用组件
 *
 */
public class BeanFactory {

    private static Properties props;

    static {

        try {

            props = new Properties();

            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");

            props.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Object getBean(String beanName){
        Object bean = null;

        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;

    }

}
