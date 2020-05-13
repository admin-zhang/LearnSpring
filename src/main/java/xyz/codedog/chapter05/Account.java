package xyz.codedog.chapter05;

/**
 * @ClassName Account
 * @Description 账户
 * @Author Administrator
 * @Date 2020/5/10 19:17
 * @Version 1.0
 **/
public class Account {
    private Integer id;
    private String username;
    private Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}
