package com.example.department_search_manager.ennity;
/**
 * @author ADMIN
 */
public class Department {
    private int iD;
    private String nameDepartment;
    private String area;
    private String address;
    private double price;
    private String imageUrl;
    private User user;

    public Department() {
    }

    public Department(int iD, String nameDepartment, String area, String address, double price, String imageUrl, User user) {
        this.iD = iD;
        this.nameDepartment = nameDepartment;
        this.area = area;
        this.address = address;
        this.price = price;
        this.imageUrl = imageUrl;
        this.user = user;
    }

    public Department(int iD, User user) {
        this.iD = iD;
        this.user = user;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

