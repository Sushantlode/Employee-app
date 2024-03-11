package com.jetbrains.employeeapp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/insert")
public class insertData extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("username");
        String city = req.getParameter("city");
        String password= req.getParameter("password");
        try {
            String url = "jdbc:mysql://localhost:3306/db";
            String username = "root";
            String pass = "root";

            try (Connection conn = DriverManager.getConnection(url, username, pass)) {

                String sql = "insert into logindata(id,username, city,password) values (?,?,?,?);";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);
                statement.setString(2, name);
                statement.setString(3, city);
                statement.setString(4,password);

                int resultSet = statement.executeUpdate();
                if (resultSet > 0) {
                    HttpSession session=req.getSession();
                    session.setAttribute("id", id);
                    session.setAttribute("username",name);
                    session.setAttribute("city", city);
                    session.setAttribute("password",password);
                    RequestDispatcher rd = req.getRequestDispatcher("userdata.jsp");
                    rd.forward(req, resp);

                } else if (resultSet < 0) {
                    RequestDispatcher rd= req.getRequestDispatcher("register.jsp");

                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }catch (Exception i){
            i.getStackTrace();
        }
    }
}