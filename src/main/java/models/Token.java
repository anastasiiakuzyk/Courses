package models;

public class Token {
    private int user_id;
    private String token;

    public Token() {
    }

    public Token(String token) {
        this.token = token;
    }

    public Token(int user_id, String token) {
        this.user_id = user_id;
        this.token = token;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getToken() {
        return token;
    }
}
