package com.example.department_search_manager.ennity;

public class User {
    private int iD;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String Email;
    private String numberPhone;
    private String userType;

    public User() {
    }

    public User(int iD, String userName, String password, String firstName, String lastName, String email, String numberPhone, String userType) {
        this.iD = iD;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.numberPhone = numberPhone;
        this.userType = userType;
    }

    public User(int iD, String userName, String password) {
        this.iD = iD;
        this.userName = userName;
        this.password = password;
    }

    public User(int iD, String userType) {
        this.iD = iD;
        this.userType = userType;
    }

    public User(int iD, String userName, String password, String firstName, String lastName, String email, String numberPhone) {
        this.iD = iD;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.numberPhone = numberPhone;
    }

    public User(int userId) {
        this.iD = userId;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
