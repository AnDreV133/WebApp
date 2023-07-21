package Servlets;

import SQL.SQLHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

//@WebServlet("/log-in/notion")
public class LogInServlet extends HttpServlet {
    SQLHandler sql = new SQLHandler();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        if (sql.isUserInTable(params.get("username")[0], params.get("password")[0])) {
            resp.sendRedirect("HTMLnJSP/user-page.jsp");
        } else {
            resp.sendRedirect("HTMLnJSP/sign-in.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("HTMLnJSP/log-in-page.jsp");
    }
}
