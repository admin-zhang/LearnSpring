package xyz.codedog.chapter02.annotation.impl;

import org.springframework.stereotype.Repository;
import xyz.codedog.chapter02.annotation.UserDao;

/**
 * @ClassName UserDaoImpl
 * @Description
 * @Author Administrator
 * @Date 2020/5/6 9:20
 * @Version 1.0
 **/
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("userdao....save....");
    }
}
