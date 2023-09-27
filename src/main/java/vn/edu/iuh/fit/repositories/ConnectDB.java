package vn.edu.iuh.fit.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
  private static ConnectDB instance;
  private final Connection connection;

    public ConnectDB() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://localhost:3306/mydb";
        connection = DriverManager.getConnection(url,"root","0988434215az");
    }
    public Connection getConnection(){
        return connection;
    }
    public static ConnectDB getInstance() throws SQLException, ClassNotFoundException {
        if(instance == null){
            instance = new ConnectDB();
        }
        return instance;
    }
}
