package xyz.codedog.chapter03.cglib;

/**
 * @ClassName UserDao
 * @Description CGLIB代理
 * @Author Administrator
 * @Date 2020/5/7 17:20
 * @Version 1.0
 **/
public class UserDao {
    public void addUser() {
        System.out.println("cglib 代理 === 添加用户");
    }

    public void deleteUser() {
        System.out.println("cglib 代理 === 删除用户");
    }
}
