package cn.gok;

/**
 * @auther:huangjianxin
 * @create 2019-11-10 9:59
 * @description
 */
public class User {
    private String username="sf";

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
