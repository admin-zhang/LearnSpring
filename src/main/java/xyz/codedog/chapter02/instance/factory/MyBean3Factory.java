package xyz.codedog.chapter02.instance.factory;

/**
 * @ClassName MyBean3Factory
 * @Description 实例工厂方式实例化
 * @Author Administrator
 * @Date 2020/5/5 20:16
 * @Version 1.0
 **/
public class MyBean3Factory {
    public MyBean3Factory() {
        System.out.println("bean3工厂实例化");
    }

    //创建 Bean3 实例的方法
    public Bean3 createBean() {
        return new Bean3();
    }
}
