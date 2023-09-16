package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRepository {
    Connection connection;
    private static final String SELECT_ROLE_BY_ID = "select * from role"
            + " where role_id = ?;";
    public RoleRepository() {
    }
    public Role selectRole(String role_id){
        Role role = null;
        try {
            connection = ConnectDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_BY_ID);
            preparedStatement.setString(1, role_id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString("role_id");
                String role_name = rs.getString("role_name");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                role = new Role(id,role_name,description,status);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return role;
    }
}
