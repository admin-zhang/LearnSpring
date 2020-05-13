package xyz.codedog.chapter05.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import xyz.codedog.chapter05.Account;
import xyz.codedog.chapter05.AccountDao;

import java.util.List;

/**
 * @ClassName AccountDaoImpl
 * @Description
 * @Author Administrator
 * @Date 2020/5/10 19:45
 * @Version 1.0
 **/
public class AccountDaoImpl implements AccountDao {
    //    声明 JdbcTemplate 属性及其 setter 方法
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 添加账户
     * @param account
     * @return
     */
    @Override
    public int addAccount(Account account) {
        String sql = "insert into account(username,balance) value(?,?)";
        Object[] objects = new Object[]{
                account.getUsername(),
                account.getBalance()
        };
        int num = this.jdbcTemplate.update(sql, objects);
        return num;
    }

    /**
     * 更新账户
     * @param account
     * @return
     */
    @Override
    public int updateAccount(Account account) {
        String sql = "update account set username=?,balance=? where id = ?";
        Object[] params = new Object[]{
                account.getUsername(),
                account.getBalance(),
                account.getId()
        };
        int num = this.jdbcTemplate.update(sql, params);
        return num;
    }

    /**
     * 删除账户
     * @param id
     * @return
     */
    @Override
    public int deleteAccount(int id) {
        String sql = "delete from account where id = ?";
        int num = this.jdbcTemplate.update(sql, id);
        return num;
    }

    /**
     * 通过 id 查询
     * @param id
     * @return
     */
    @Override
    public Account findAccountById(int id) {
        String sql = "select * from account where id = ?";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    /**
     * 查询所有账户
     * @return
     */
    @Override
    public List<Account> findAllAccount() {
        String sql = "select * from account";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    /**
     * 转账
     * @param outUser 汇款人
     * @param inUser 收款人
     * @param money 收款金额
     */
    @Override
    public void transfer(String outUser, String inUser, Double money) {
        //    收款时，收款用户的余额=现有余额+所汇金额
        this.jdbcTemplate.update("update account set balance = balance + ?" +
                "where username = ?", money, inUser);
        //    模拟系统运行时的突发性问题
        int i = 1 / 0;
        //    汇款时，汇款用户的余额=现有金额-所汇金额
        this.jdbcTemplate.update("update account set balance = balance-?" +
                "where username = ?", money, outUser);
    }
}
