package xyz.codedog.chapter03.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @ClassName MyAspect
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/9 17:25
 * @Version 1.0
 **/
public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        check_Permissions();
        Object object = invocation.proceed();
        log();
        return object;
    }

    private void check_Permissions() {
        System.out.println("模拟检查权限.....");
    }

    public void log() {
        System.out.println("模拟记录日志.......");
    }
}
