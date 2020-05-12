package xyz.codedog.chapter04;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import xyz.codedog.chapter04.jdbc.Account;
import xyz.codedog.chapter04.jdbc.AccountDao;

import java.util.List;

/**
 * @ClassName Chapter04Test
 * @Description Spring和数据库 测试类
 * @Author Administrator
 * @Date 2020/5/10 18:44
 * @Version 1.0
 **/
public class Chapter04Test {
    private final static String xmlPath = "xyz/codedog/chapter04/applicationContext.xml";
    /**
     * 测试 JdbcTemplate 的 execute() 方法 =====> 建表
     */
    @Test
    public void testExecute() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.execute("create table account(" +
                "id int primary key auto_increment," +
                "username varchar(50)," +
                "balance double)");
        System.out.println("建表成功");
    }

    /**
     * 测试 JdbcTemplate 的 update() 方法 =====> 增删改
     */
    @Test
    public void testUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        Account account = new Account();
        account.setUsername("lucy");
        account.setBalance(3000.00);

        System.out.println("============================");
        System.out.println("开始执行插入操作");
        int num = accountDao.addAccount(account);
        if (num > 0) {
            System.out.println("成功插入了" + num + "条数据！");
        }else {
            System.out.println("插入操作失败！");
        }
        System.out.println("插入操作执行完毕");
        System.out.println("============================");
        System.out.println("开始执行更新操作");
        account.setId(1);
        account.setUsername("tom");
        account.setBalance(2000.00);
        num = accountDao.updateAccount(account);
        if (num > 0) {
            System.out.println("成功修改了" + num + "条数据！");
        }else {
            System.out.println("修改操作失败！");
        }
        System.out.println("更新操作执行完毕");
        System.out.println("============================");
        System.out.println("开始执行删除操作");
        num = accountDao.deleteAccount(1);
        if (num > 0) {
            System.out.println("成功删除了" + num + "条数据！");
        }else {
            System.out.println("删除操作失败！");
        }
        System.out.println("删除操作执行完毕");
        System.out.println("============================");
    }

    /**
     * 测试 JdbcTemplate 的 query() 方法 =====> 查询
     */
    @Test
    public void testQuery() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        System.out.println("=============================");
        System.out.println("根据id进行查询");
        Account account = accountDao.findAccountById(2);
        System.out.println(account);
        System.out.println("=============================");
        System.out.println("查询所有");
        List<Account> accountList = accountDao.findAllAccount();
        for (Account account1 : accountList) {
            System.out.println(account1);
        }
    }
}
