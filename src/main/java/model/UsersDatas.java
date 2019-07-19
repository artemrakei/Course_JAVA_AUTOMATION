package model;

public class UsersDatas {
    private int id;
    private String login;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String code) {
        this.password = code;
    }

    @Override
    public String toString() {
        return "UsersDatas=" + this.id + " Login=" + this.login + " Password=" + this.password;
    }

}
