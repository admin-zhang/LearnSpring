package xyz.codedog.chapter03.jdk;

import xyz.codedog.chapter03.aspect.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JdkProxy
 * @Description JDK代理类
 * @Author Administrator
 * @Date 2020/5/6 10:48
 * @Version 1.0
 **/
public class JdkProxy implements InvocationHandler {
    //声明目标类接口
    private UserDao userDao;

    /**
     * 创建代理方法
     * @param userDao
     * @return
     */
    public Object createProxy(UserDao userDao) {
        this.userDao = userDao;
        //1.类加载器
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        //2.被代理对象实现的所有接口
        Class[] clazz = userDao.getClass().getInterfaces();
        //3.使用代理类，进行增强，返回的是代理后的对象
        return Proxy.newProxyInstance(classLoader, clazz, this);
    }

    /**
     * 所有动态代理类的方法调用，都会交给invoke()方法去处理
     * @param proxy 被代理后的对象
     * @param method 将要被执行的方法信息（反射）
     * @param args 执行方法时需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //声明切面
        MyAspect myAspect = new MyAspect();
        //前增强
        myAspect.check_Permissions();
        //在目标类上调用方法，并传入参数
        Object object = method.invoke(userDao, args);
        //后增强
        myAspect.log();
        return object;
    }
}
