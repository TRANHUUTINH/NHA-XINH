package com.example.department_search_manager.repository;


import com.example.department_search_manager.ennity.Department;
import com.example.department_search_manager.ennity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ADMIN
 */
public class DepartmentRepository {
    private static  Connection connection;

    public DepartmentRepository() {
        connection = ConnectionConfig.getConnection();
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        try {
            String query = "SELECT * FROM DEPARTMENT";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String area = resultSet.getString("AREA");
                String address = resultSet.getString("ADDRESS");
                double price = resultSet.getDouble("PRICE");
                String imageUrl = resultSet.getString("IMAGE_URL");
                int userId = resultSet.getInt("ID_USER");

                User user = getUserById(userId);

                Department department = new Department(id, name, area, address, price, imageUrl, user);
                departments.add(department);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }


    public List<Department> getDepartmentsByUserId(int userId) {
        List<Department> userDepartments = new ArrayList<>();
        try {
            String query = "SELECT * FROM DEPARTMENT WHERE ID_USER=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String area = resultSet.getString("AREA");
                String address = resultSet.getString("ADDRESS");
                double price = resultSet.getDouble("PRICE");
                String imageUrl = resultSet.getString("IMAGE_URL");

                User user = getUserById(userId);

                Department department = new Department(id, name, area, address, price, imageUrl, user);
                userDepartments.add(department);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userDepartments;
    }


    public boolean addDepartment(Department department) {
        try {
            String query = "INSERT INTO DEPARTMENT (NAME, AREA, ADDRESS, PRICE, ID_USER, IMAGE_URL) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, department.getNameDepartment());
            preparedStatement.setString(2, department.getArea());
            preparedStatement.setString(3, department.getAddress());
            preparedStatement.setDouble(4, department.getPrice());
            preparedStatement.setInt(5, department.getUser().getiD());
            preparedStatement.setString(6, department.getImageUrl());

            int rowsInserted = preparedStatement.executeUpdate();
            preparedStatement.close();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteDepartment(int departmentId, int userId) {
        try {
            String query = "DELETE FROM DEPARTMENT WHERE ID=? AND ID_USER=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, departmentId);
            preparedStatement.setInt(2, userId);

            int rowsDeleted = preparedStatement.executeUpdate();
            preparedStatement.close();

            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private static User getUserById(int userId) {
        User user = null;
        try {
            String query = "SELECT * FROM USER WHERE ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("USERNAME");
                String numberPhone = resultSet.getString("NUMBERPHONE");
                user = new User(userId, username, numberPhone);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
