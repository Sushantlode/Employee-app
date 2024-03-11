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
import java.sql.ResultSet;


@WebServlet("/userdata")
public class userdata extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        String username= (String) session.getAttribute("username");
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String pass = "root";
       try {
           Connection conn = DriverManager.getConnection(url, user, pass);
           String sql = "SELECT id,username,city,password FROM logindata WHERE username = ?";
           PreparedStatement statement = conn.prepareStatement(sql);
           statement.setString(1, username);
           ResultSet resultSet = statement.executeQuery();
           while(resultSet.next()){
               session.setAttribute("id",resultSet.getInt("id"));
               session.setAttribute("username",resultSet.getString("username"));
               session.setAttribute("city",resultSet.getString("city"));
               session.setAttribute("password",resultSet.getString("password"));
               RequestDispatcher rd=req.getRequestDispatcher("userdata.jsp");
               rd.forward(req,resp);
           }
       }catch (Exception e){
           e.getLocalizedMessage();
       }

    }
}
