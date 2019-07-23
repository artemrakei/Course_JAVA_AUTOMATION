public class UsersDatas {

    private int id;
    private String login;
    private String password;

    public int getId() {
        return id;
    }

    public UsersDatas setId(int id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UsersDatas setLogin(String name) {
        this.login = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UsersDatas setPassword(String code) {
        this.password = code;
        return this;
    }

    @Override
    public String toString() {
        return "UsersDatas=" + this.id + " Login=" + this.login + " Password=" + this.password;
    }

}
