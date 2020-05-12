package xyz.codedog.chapter02.annotation.impl;

import org.springframework.stereotype.Service;
import xyz.codedog.chapter02.annotation.UserDao;
import xyz.codedog.chapter02.annotation.UserService;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author Administrator
 * @Date 2020/5/6 9:22
 * @Version 1.0
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;
    @Override
    public void save() {
        this.userDao.save();
        System.out.println("userService ..... save .....");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
