package xyz.codedog.chapter01.ioc.impl;

import xyz.codedog.chapter01.ioc.UserDao;
import xyz.codedog.chapter01.ioc.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/5 19:31
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void say() {
        this.userDao.say();
        System.out.println("userService say hello world!");
    }
}
