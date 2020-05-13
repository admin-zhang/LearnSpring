package xyz.codedog.chapter05;

import java.util.List;

/**
 * @ClassName AccountDao
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/10 19:43
 * @Version 1.0
 **/
public interface AccountDao {
    //    添加
    public int addAccount(Account account);

    //    更新
    public int updateAccount(Account account);

    //    删除
    public int deleteAccount(int id);

    //    通过 id 查询
    public Account findAccountById(int id);

    //    查询所有账户
    public List<Account> findAllAccount();

    //    转账
    public void transfer(String outUser, String inUser, Double money);
}
