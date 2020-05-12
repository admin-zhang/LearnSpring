package xyz.codedog.chapter02.instance.constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.codedog.chapter02.annotation.UserController;

/**
 * @ClassName Chapter02Test
 * @Description 第二章测试类
 * @Author Administrator
 * @Date 2020/5/5 20:08
 * @Version 1.0
 **/
public class Chapter02Test {
    private static final String xmlPath = "xyz\\codedog\\chapter02\\applicationContext.xml";

    /**
     * 测试构造方法实例化
     */
    @Test
    public void testConstructor() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        System.out.println(bean1);
    }

    /**
     *  测试静态工厂实例化
     */
    @Test
    public void testStaticFactory() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        System.out.println(applicationContext.getBean("bean2"));
    }

    /**
     * 测试实例工厂实例化
     */
    @Test
    public void testFactory() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        System.out.println(applicationContext.getBean("bean3"));
    }

    /**
     * 测试 作用域 ===> singleton
     */
    @Test
    public void testSingleton() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        System.out.println("===>第一次输出");
        System.out.println(applicationContext.getBean("scope"));
        System.out.println("===>第二次输出");
        System.out.println(applicationContext.getBean("scope"));
    }

    /**
     * 测试作用域 ===> prototype
     */
    @Test
    public void testPrototype() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        System.out.println("===>第一次输出");
        System.out.println(applicationContext.getBean("scope1"));
        System.out.println("===>第二次输出");
        System.out.println(applicationContext.getBean("scope1"));
    }

    /**
     * Bean 的装配方式
     * 1.基于 xml 方式
     */
    @Test
    public void testAssembleXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //构造方式输出结果
        System.out.println("构造方式输出结果===> " + applicationContext.getBean("user1"));
        //设值方式输出结果
        System.out.println("设值方式输出结果===> " + applicationContext.getBean("user2"));
    }

    /**
     * 测试注解 annotation
     */
    @Test
    public void testAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserController userController = (UserController) applicationContext.getBean("userController");
        userController.save();
    }
}
