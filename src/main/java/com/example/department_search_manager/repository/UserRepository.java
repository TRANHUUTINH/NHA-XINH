package com.example.department_search_manager.repository;


import com.example.department_search_manager.ennity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public User getUserByUserName(String username) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {
            conn = ConnectionConfig.getConnection();
            String query = "SELECT * FROM USER WHERE USERNAME = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String userName = resultSet.getString("USERNAME");
                String password = resultSet.getString("PASSWORD");
                user = new User(id, userName, password, null, null, null, null, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {
            conn = ConnectionConfig.getConnection();
            String query = "SELECT * FROM USER";
            stmt = conn.prepareStatement(query);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String userName = resultSet.getString("USERNAME");
                String password = resultSet.getString("PASSWORD");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String email = resultSet.getString("EMAIL");
                String numberPhone = resultSet.getString("NUMBER_PHONE");
                String userType = resultSet.getString("USERTYPE");
                User user = new User(id, userName, password, firstName, lastName, email, numberPhone, userType);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public static boolean updateUser(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionConfig.getConnection();
            String query = "UPDATE USER SET USERNAME = ?, PASSWORD = ?, FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, NUMBER_PHONE = ? WHERE ID = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getLastName());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getNumberPhone());
            stmt.setInt(7, user.getiD());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean deleteUser(int userId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionConfig.getConnection();
            String query = "DELETE FROM USER WHERE ID = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
