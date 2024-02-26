package com.example.department_search_manager.repository;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author ADMIN
 */
public class ConnectionConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/DEPARTMENT_SEARCH_MANAGER";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
