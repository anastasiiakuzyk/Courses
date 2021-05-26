package services;

import database.MySQLConnection;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

public class TokenService {
    private static final String INSERT = "insert into tokens (user_id,token) values(?,?)";
    private static final String UPDATE = "update tokens " +
            "set token = ? " +
            "where user_id = ?";


    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    public String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public void setToken(int user_id, String token) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select 1 from tokens where user_id = ?");
        preparedStatement.setInt(1, user_id);
        if (preparedStatement.executeQuery().next()){
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, token);
            preparedStatement.setInt(2, user_id);
        } else {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setString(2, token);
        }
        preparedStatement.executeUpdate();
        connection.close();
    }
}
