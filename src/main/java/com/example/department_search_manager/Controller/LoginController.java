package com.example.department_search_manager.Controller;


import com.example.department_search_manager.Service.LoginService;
import com.example.department_search_manager.Service.UserService;
import com.example.department_search_manager.ennity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginService", value = {"/login", "/logout"})
public class LoginController extends HttpServlet {
    private LoginService loginService;
    private UserService userService;
    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginService();
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean success;
        User user = null;
        try {
            success = loginService.authenticate(username, password);
            if (success) {
                user = userService.getUserByUserName(username);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/home.jsp");

                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }

        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath() + "/home.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logoutUser(request, response);
    }
}