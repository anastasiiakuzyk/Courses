package models;

public class User {
    private int id;
    private String name = "";
    private String email = "";
    private String password = "";
    private int roleId;

    public User(String name, String email, String password, int roleId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name, String email, String password, int roleId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public User() {
    }

    public User(int id, String name, int course, int anInt) {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        switch (roleId) {
            case 1:
                return "Адміністратор";
            case 2:
                return "Викладач";
            case 3:
                return "Студент";
        }
        return null;
    }

    public int getRoleId() {
        return roleId;
    }
}
