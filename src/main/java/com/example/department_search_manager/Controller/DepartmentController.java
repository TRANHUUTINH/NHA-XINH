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

@WebServlet("/departments")
public class DepartmentController extends HttpServlet {
    private final DepartmentService departmentService;

    public DepartmentController() {
        departmentService = new DepartmentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        if (currentUser != null) {
            List<Department> userDepartments = departmentService.getDepartmentsByUserId(currentUser.getiD());
            request.setAttribute("userDepartments", userDepartments);
        }

        List<Department> allDepartments = departmentService.getAllDepartments();
        request.setAttribute("allDepartments", allDepartments);

        request.getRequestDispatcher("department_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        String action = request.getParameter("action");

        if (action != null && currentUser != null) {
            if (action.equals("add")) {
                String name = request.getParameter("name");
                String area = request.getParameter("area");
                String address = request.getParameter("address");
                double price = Double.parseDouble(request.getParameter("price"));
                String imageUrl = request.getParameter("image_url");

                Department department = new Department(0, name, area, address, price, imageUrl, currentUser);
                departmentService.addDepartment(department);
            } else if (action.equals("delete")) {
                int departmentId = Integer.parseInt(request.getParameter("department_id"));
                departmentService.deleteDepartment(departmentId, currentUser.getiD());
            }
        }

        response.sendRedirect(request.getContextPath() + "/departments");
    }
}
