package xyz.codedog.chapter03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.codedog.chapter03.cglib.CglibProxy;
import xyz.codedog.chapter03.jdk.JdkProxy;
import xyz.codedog.chapter03.jdk.UserDao;
import xyz.codedog.chapter03.jdk.impl.UserDaoImpl;

/**
 * @ClassName Chapter03Test
 * @Description 第三章测试类
 * @Author Administrator
 * @Date 2020/5/6 10:55
 * @Version 1.0
 **/
public class Chapter03Test {
    /**
     * JDK 动态代理测试
     */
    @Test
    public void testJdk() {
        //创建代理对象
        JdkProxy jdkProxy = new JdkProxy();
        //创建目标对象
        UserDao userDao = new UserDaoImpl();
        //从代理对象中获取增强后的目标对象
        UserDao userDao1 = (UserDao) jdkProxy.createProxy(userDao);
        //执行方法
        userDao1.addUser();
        userDao1.deleteUser();
    }

    @Test
    public void testCglib() {
        //创建代理对象
        CglibProxy cglibProxy = new CglibProxy();
        //创建目标对象
        xyz.codedog.chapter03.cglib.UserDao userDao = new xyz.codedog.chapter03.cglib.UserDao();
        //获取增强后的目标对象
        xyz.codedog.chapter03.cglib.UserDao userDao1 = (xyz.codedog.chapter03.cglib.UserDao) cglibProxy.createProxy(userDao);
        //执行方法
        userDao1.addUser();
        userDao1.deleteUser();
    }

    /**
     * 基于代理类的 AOP 实现的测试
     */
    @Test
    public void testProxyFactoryBean() {
        String xmlPath = "xyz\\codedog\\chapter03\\applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoProxy");
        userDao.addUser();
        userDao.deleteUser();
    }

    /**
     * 测试 XML 方式的 AspectJ
     */
    @Test
    public void testAspectXML() {
        String xmlPath = "xyz\\codedog\\chapter03\\applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.addUser();
    }

    @Test
    public void testAspectJAnnotation() {
        String xmlPath = "xyz\\codedog\\chapter03\\applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.addUser();
    }
}
