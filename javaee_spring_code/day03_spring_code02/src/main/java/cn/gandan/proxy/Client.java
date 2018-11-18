package cn.gandan.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {

        final Producer producer = new Producer();

        Producer o = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都经过该方法
             * @param o
             * @param method
             * @param objects
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                String name = (String) objects[0];

                Object value = null;

                if ("sale".equals(method.getName())) {
                    value = method.invoke(producer, "爱" + name);
                }
                return value;
            }
        });

        o.sale("顾加浏");





/*
        IProducer o = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                String name = (String) args[0];

                Object value = null;

                if ("sale".equals(method.getName())) {
                    value = method.invoke(producer, "爱" + name);
                }
                return value;
            }
        });

        o.sale("顾加浏");*/

    }

}
