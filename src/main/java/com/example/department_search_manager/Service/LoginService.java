package com.example.department_search_manager.Service;


import com.example.department_search_manager.ennity.User;
import com.example.department_search_manager.repository.ConnectionConfig;
import com.example.department_search_manager.repository.LoginRepository;

import java.sql.SQLException;

public class LoginService {
    private LoginRepository loginRepository;
    public LoginService(){
        loginRepository = new LoginRepository();
    }
    public User login(String username, String password) throws SQLException {
        ConnectionConfig connectionConfig = new ConnectionConfig();
        ConnectionConfig.getConnection();
        User user = loginRepository.getUserByUserName(username);
        String pass = user.getPassword();
        if(pass.equals(password)){
            return user;
        }
        return null;
    }

    public boolean authenticate(String username, String password) throws SQLException {
        User user = login(username, password);
        return user != null;
    }
}