package xyz.codedog.chapter03.jdk.impl;

import org.springframework.stereotype.Repository;
import xyz.codedog.chapter03.jdk.UserDao;

/**
 * @ClassName UserDaoImpl
 * @Description JDK动态代理
 * @Author Administrator
 * @Date 2020/5/6 9:53
 * @Version 1.0
 **/
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
