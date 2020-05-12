package xyz.codedog.chapter02.instance.static_factory;

/**
 * @ClassName MyBean2Factory
 * @Description 工厂类
 * @Author Administrator
 * @Date 2020/5/5 20:12
 * @Version 1.0
 **/
public class MyBean2Factory {
//    使用自己的工厂创建 Bean2 实例
    public static Bean2 createBean() {
        return new Bean2();
    }
}
