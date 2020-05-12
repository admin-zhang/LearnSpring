package xyz.codedog.chapter01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.codedog.chapter01.ioc.UserDao;
import xyz.codedog.chapter01.ioc.UserService;

/**
 * @ClassName Chapter01Main
 * @Description 第一张测试
 * @Author Administrator
 * @Date 2020/5/5 19:10
 * @Version 1.0
 **/
public class TestIOC {

    @Test
    public void testDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xyz\\codedog\\chapter01\\applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.say();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xyz\\codedog\\chapter01\\applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.say();
    }
}
