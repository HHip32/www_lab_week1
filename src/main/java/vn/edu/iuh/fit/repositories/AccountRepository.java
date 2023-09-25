package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    private Connection connection;

    private static final String INSERT_ACCOUNT_SQL = "insert into account"
            + "(account_id, full_name, password, email, phone, status) values"
            + " (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ACCOUNT_BY_ID = "select * from account"
            + " where account_id = ?;";
    private static final String SELECT_ALL_ACCOUNT = "SELECT * FROM account"
            + " where status != ?;";
    private static final String DELETE_ACCOUNT_SQL = "update account "
            + " set status = ?"
            + " where account_id = ?;";
    private static final String UPDATE_ACCOUNT_SQL = "update account"
            + " set full_name = ?, password = ?, email = ?, phone = ?, status = ?"
            + " where account_id = ?;";

    public AccountRepository() {
    }


    public Account checkLogin(String email, String password){
        Account account = null;
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from account" + " where email = ? and password = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,email);
            statement.setString(2,password);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String acc_id = rs.getString("account_id");
                String fullName = rs.getString("full_name");
                String pass = rs.getString("password");
                String em = rs.getString("email");
                String phone = rs.getString("phone");
                int status = rs.getInt("status");
                account = new Account(acc_id,fullName,pass,em,phone,status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return  account;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public boolean insertAccount(Account account) throws SQLException, ClassNotFoundException {
        connection = ConnectDB.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT_SQL);
            preparedStatement.setString(1, account.getAccountId());
            preparedStatement.setString(2, account.getFullName());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5, account.getPhone());
            preparedStatement.setInt(6, account.getStatus());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            printSQLException(e);
            return false;
        }
    }

    public Account selectAccountByEmail(String email){
        Account account = null;
        String sql = "select * from account"
                + " where email = ?;";

        try {
            connection = ConnectDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String acc_id = rs.getString("account_id");
                String fullName = rs.getString("full_name");
                String password = rs.getString("password");
                String email1 = rs.getString("email");
                String phone = rs.getString("phone");
                int status = rs.getInt("status");
                account = new Account(acc_id, fullName, password, email1, phone, status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return account;
    }
    public Account selectAccount(String account_id) {
        Account account = null;

        try {
            connection = ConnectDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID);
            preparedStatement.setString(1, account_id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String acc_id = rs.getString("account_id");
                String fullName = rs.getString("full_name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int status = rs.getInt("status");
                account = new Account(acc_id, fullName, password, email, phone, status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    public List<Account> selectAllAccount() throws SQLException {
        List<Account> accounts = new ArrayList<>();

        try {

            connection = ConnectDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT);
            preparedStatement.setInt(1,-1);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String acc_id = rs.getString("account_id");
                String fullName = rs.getString("full_name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int status = rs.getInt("status");
                accounts.add(new Account(acc_id, fullName, password, email, phone, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }
    public List<Account> selectAllAccountNotIncludeAdmin(String account_id) throws SQLException {
        List<Account> accounts = new ArrayList<>();

        try {

            connection = ConnectDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from account"
                    + " where account_id != ? and status != ?;");
            preparedStatement.setString(1, account_id);
            preparedStatement.setInt(2,-1);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String acc_id = rs.getString("account_id");
                String fullName = rs.getString("full_name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int status = rs.getInt("status");
                accounts.add(new Account(acc_id, fullName, password, email, phone, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    public boolean updateAccount(Account account) throws SQLException, ClassNotFoundException {
        boolean rowUpdate;

        connection = ConnectDB.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_SQL);
        System.out.println("Update statement: " + preparedStatement);
        preparedStatement.setString(1, account.getFullName());
        preparedStatement.setString(2, account.getPassword());
        preparedStatement.setString(3, account.getEmail());
        preparedStatement.setString(4, account.getPhone());
        preparedStatement.setInt(5, account.getStatus());
        preparedStatement.setString(6, account.getAccountId());
        rowUpdate = preparedStatement.executeUpdate() > 0;

        return rowUpdate;
    }

    public boolean deleteAccount(String accountId) throws SQLException, ClassNotFoundException {
        boolean rowDelete;

        connection = ConnectDB.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT_SQL);
        preparedStatement.setInt(1, -1);
        preparedStatement.setString(2, accountId);

        rowDelete = preparedStatement.executeUpdate() > 0;

        return rowDelete;
    }

}
