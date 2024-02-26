package com.example.department_search_manager.Controller;


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
import java.util.List;

@WebServlet(name = "UserController", value = "/user")
public class UserController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "view":
                    int id= Integer.parseInt(req.getParameter("id"));
                    User user= userService.getById(id);
                    req.setAttribute("user", user);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/users.jsp");
                    dispatcher.forward(req, resp);
                    break;
                default:
                    List<User> userList = userService.getAllUsers();

                    req.setAttribute("users", userList);
                    HttpSession session = req.getSession();
                    User loggedInUser = (User) session.getAttribute("user");
                    req.setAttribute("loggedInUser", loggedInUser);

                    RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/users.jsp");
                    dispatcher1.forward(req, resp);
            }
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "update":
                    try {
                        updateUser(req, resp);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "delete":
                    deleteUser(req, resp);
                    break;
                default:
                    break;
            }
        }
    }


    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int userID = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String numberPhone = req.getParameter("numberPhone");
        String userType = req.getParameter("userType");

        User user = new User(userID, username, password, firstName, lastName, email, numberPhone, userType);
        String errorMessage = null;
        boolean success = userService.updateUser(user);
        if (success) {
            resp.sendRedirect(req.getContextPath() + "/users.jsp");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        }
    }


    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userID = Integer.parseInt(req.getParameter("userID"));

        boolean success = userService.deleteUser(userID);
        if (success) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/users.jsp");
            dispatcher.forward(req, resp);
        } else {
            String errorMessage = "Có lỗi xảy ra khi cập nhật người dùng. Vui lòng thử lại sau.";
            req.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        }
    }
}

