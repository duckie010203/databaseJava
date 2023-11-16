package javaapplication8.context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    public Connection getConnection() throws Exception{
        String url = "jdbc:postgresql://localhost:5432/posgresql";
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url , userID , password);
    }
    private final String userID = "posgresql";
    private final String password = "posgresql";



}
