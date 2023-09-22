package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Logs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LogRepository {
    private Connection connection;

    public void insertLogs(String accountID, LocalDateTime loginTime) throws SQLException, ClassNotFoundException {

//        khởi tạo kết nối đến csdl
        connection = ConnectDB.getInstance().getConnection();

//        chuyển đổi dữ liệu để thêm vào csdl
        Timestamp loginTimestamp = Timestamp.valueOf(loginTime);

        String sql = "INSERT INTO log(account_id,login_time) values(?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, accountID);
        preparedStatement.setTimestamp(2, loginTimestamp);

//         Thực hiện thêm
        preparedStatement.executeUpdate();
    }

    public void updateLogs(String accountID, LocalDateTime logoutTime) throws SQLException, ClassNotFoundException {
        //        khởi tạo kết nối đến csdl
        connection = ConnectDB.getInstance().getConnection();

//        chuyển đổi dữ liệu để thêm vào csdl
        Timestamp logoutTimestamp = Timestamp.valueOf(logoutTime);

        String sql = "UPDATE log set logout_time = ?" +
                " where account_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setTimestamp(1, logoutTimestamp);
        preparedStatement.setString(2, accountID);

//         Thực hiện thêm
        preparedStatement.executeUpdate();

    }

}
