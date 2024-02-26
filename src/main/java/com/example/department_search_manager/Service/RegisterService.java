package com.example.department_search_manager.Service;


import com.example.department_search_manager.ennity.User;
import com.example.department_search_manager.repository.LoginRepository;
import com.example.department_search_manager.repository.RegisterRepository;

import java.sql.SQLException;

public class RegisterService {
    private LoginRepository loginRepository;
    private RegisterRepository registerRepository;

    public RegisterService() {
        loginRepository = new LoginRepository();
        registerRepository = new RegisterRepository();
    }

    public boolean register(User user) throws SQLException {
        if (loginRepository.getUserByUserName(user.getUserName()) != null) {
            return false;
        } else {
            return registerRepository.insertUser(user);
        }
    }

    public boolean insertUser(String username, String password, String firstName,String lastName, String email, String phoneNumber) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setNumberPhone(phoneNumber);
        return registerRepository.insertUser(user);
    }
}

