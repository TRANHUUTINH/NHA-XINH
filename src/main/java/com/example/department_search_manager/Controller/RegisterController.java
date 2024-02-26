package com.example.department_search_manager.Controller;


import com.example.department_search_manager.Service.RegisterService;
import com.example.department_search_manager.ennity.User;
import com.example.department_search_manager.repository.RegisterRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterController extends HttpServlet {
    private RegisterService registerService;

    @Override
    public void init() throws ServletException {
        super.init();
        registerService = new RegisterService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");

        boolean result = registerService.insertUser(username,password,firstName,lastName,email,phoneNumber);
        if (result){
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }else {
            String errorMessage = "Có lỗi xảy ra khi cập nhật người dùng. Vui lòng thử lại sau.";
            response.sendRedirect(request.getContextPath() + "/register.jsp");
        }
//
    }
}