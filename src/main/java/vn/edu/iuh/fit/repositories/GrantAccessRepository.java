package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.GrantAccess;
import vn.edu.iuh.fit.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GrantAccessRepository {
    Connection connection;
    private static final String SELECT_GRANT_ACCESS_BY_ID = "select * from grant_access"
            + " where account_id = ?;";
    public GrantAccessRepository() {
    }

    public GrantAccess selectGrantAccess(String account_id){
        GrantAccess grantAccess = null;
        try {
            connection = ConnectDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GRANT_ACCESS_BY_ID);
            preparedStatement.setString(1, account_id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String role_id = rs.getString("role_id");
                String acc_id = rs.getString("account_id");
                grantAccess = new GrantAccess(new Role(role_id),new Account(acc_id));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return grantAccess;
    }
    public List<GrantAccess> selectListGrantAccess(String role_id){
        List<GrantAccess> grantAccess = null;
        try {
            connection = ConnectDB.getInstance().getConnection();
            String sql = "select * from grant_access"
                    + " where role_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GRANT_ACCESS_BY_ID);
            preparedStatement.setString(1, role_id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String role_id1 = rs.getString("role_id");
                String acc_id = rs.getString("account_id");
                grantAccess.add(new GrantAccess(new Role(role_id1),new Account(acc_id)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return grantAccess;
    }
}
