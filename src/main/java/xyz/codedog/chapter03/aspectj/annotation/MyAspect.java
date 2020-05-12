package xyz.codedog.chapter03.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyAspect
 * @Description 切面
 * @Author panda
 * @Date 2020/5/10 下午3:44
 * @Version 1.0
 **/
@Aspect
@Component
public class MyAspect {
    //    定义切入点表达式
    @Pointcut("execution(* xyz.codedog.chapter03.jdk.*.*(..))")
    private void myPointCut() {

    }

    //    前置通知
    @Before(value = "myPointCut()")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("前置通知:模拟执行权限检查1");
        System.out.println("目标类是:" + joinPoint.getTarget());
        System.out.println("，被植入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

    //    后置通知
    @AfterReturning(value = "myPointCut()")
    public void myAfterReturning(JoinPoint joinPoint) {
        System.out.println("后置通知：模拟记录日志...，");
        System.out.println("被植入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint JoinPoint 子接口，表示可以执行目标方法
     *       1.必须是 Object 类型的返回值
     *       2.必须接收一个参数，类型为 ProceddingJoinPoint
     *       3.必须 throws Throwable
     * @return
     * @throws Throwable
     */
    @Around(value = "myPointCut()")
    public Object myArround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //开始
        System.out.println("环绕开始：执行目标方法之前，模拟开启事务...");
        //执行当前目标方法
        Object object = proceedingJoinPoint.proceed();
        //结束
        System.out.println("环绕结束：执行目标方法之后，模拟关闭事务.....");
        return object;
    }

    //    异常通知
    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常通知：出错了" + e.getMessage());
    }

    //    最终通知
    @After(value = "myPointCut()")
    public void myAfter() {
        System.out.println("最终通知:模拟方法结束后的资源释放");
    }
}
