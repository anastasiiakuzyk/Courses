package models;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private int role_id;

    public User(String name, String email, String password, int role_id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
    }

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name, String email, String password, int role_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
    }

    public User() {
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
        switch (role_id) {
            case 1:
                return "Адміністратор";
            case 2:
                return "Викладач";
            case 3:
                return "Студент";
        }
        return null;
    }



}
