package com.example.department_search_manager.Service;


import com.example.department_search_manager.ennity.User;
import com.example.department_search_manager.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public User getUserByUserName(String username) throws SQLException {
        return userRepository.getUserByUserName(username);
    }

    public static List<User> getAllUsers() {
        return userRepository.selectAllUser();
    }

    public boolean updateUser(User user) throws SQLException {
        User existingUser = userRepository.getUserByUserName(user.getUserName());
        if (existingUser != null) {
            return userRepository.updateUser(user);
        } else {
            return false;
        }
    }

    public boolean deleteUser(int userId) {
        return userRepository.deleteUser(userId);
    }

    public static User getById(int id) {
        for (User element : getAllUsers()){
            if (element.getiD() == id){
                return element;
            }
        }
        return null;
    }
}
