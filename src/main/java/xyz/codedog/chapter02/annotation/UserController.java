package xyz.codedog.chapter02.annotation;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description
 * @Author Administrator
 * @Date 2020/5/6 9:24
 * @Version 1.0
 **/
@Controller("userController")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void save() {
        this.userService.save();
        System.out.println("userController.......save......");
    }
}
