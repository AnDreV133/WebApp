package SQL;

public class UsersTableRow {
    public UsersTableRow(String id, String login, String password, String text) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.text = text;
    }

    private String id;
    private String login;
    private String password;
    private String text;

    public void setId(String id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getText() {
        return text;
    }
}
