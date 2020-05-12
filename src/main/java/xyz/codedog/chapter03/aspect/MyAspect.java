package xyz.codedog.chapter03.aspect;

/**
 * @ClassName MyAspect
 * @Description 切面类，可以存在多个通知Advice
 * @Author Administrator
 * @Date 2020/5/6 10:03
 * @Version 1.0
 **/
public class MyAspect {
    public void check_Permissions() {
        System.out.println("模拟检查权限...");
    }

    public void log() {
        System.out.println("模拟记录日志...");
    }
}
