package com.example.department_search_manager.Controller;

import com.example.department_search_manager.Service.DepartmentService;
import com.example.department_search_manager.ennity.Department;
import com.example.department_search_manager.ennity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/user-departments")
public class UserDepartmentController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        DepartmentService departmentService = new DepartmentService();
        List<Department> departments = departmentService.getDepartmentsByUserId(user.getiD());
        request.setAttribute("departments", departments);

        request.getRequestDispatcher("/user_departments.jsp").forward(request, response);
    }
}
