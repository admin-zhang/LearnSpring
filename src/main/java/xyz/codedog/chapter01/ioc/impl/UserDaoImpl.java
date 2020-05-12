package xyz.codedog.chapter01.ioc.impl;

import xyz.codedog.chapter01.ioc.UserDao;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/5 19:00
 * @Version 1.0
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public void say() {
        System.out.println("userDao say Hello World!");
    }
}
