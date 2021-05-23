package services;

import database.MySQLConnection;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

public class TokenService {
    private static final String INSERT = "insert into tokens (user_id,token) values(?,?)";


    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    public String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public void setToken(int user_id, String token) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, token);
        preparedStatement.executeUpdate();
        connection.close();

    }
}
