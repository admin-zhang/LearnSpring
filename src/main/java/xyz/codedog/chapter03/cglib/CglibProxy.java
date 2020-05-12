package xyz.codedog.chapter03.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import xyz.codedog.chapter03.aspect.MyAspect;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxy
 * @Description 代理类
 * @Author Administrator
 * @Date 2020/5/7 17:21
 * @Version 1.0
 **/
public class CglibProxy implements MethodInterceptor {
    /**
     * 代理方法
     * @param target
     * @return
     */
    public Object createProxy(Object target) {
        //创建一个动态类对象
        Enhancer enhancer = new Enhancer();
        //确定需要增强的类，设置其父类
        enhancer.setSuperclass(target.getClass());
        //添加回调函数
        enhancer.setCallback(this);
        //返回创建的代理类
        return enhancer.create();
    }

    /**
     * @param proxy CGlib根据父类生成的代理对象
     * @param method 拦截的方法
     * @param args 拦截方法的参数数组
     * @param methodProxy 方法的代理对象，用于执行父类的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //创建切面类对象
        MyAspect myAspect = new MyAspect();
        //前增强
        myAspect.check_Permissions();
        //目标方法执行
        Object object = methodProxy.invokeSuper(proxy, args);
        //后增强
        myAspect.log();
        return object;
    }
}
