package com.jetbrains.employeeapp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String id = req.getParameter("id");
        String city = req.getParameter("city");
        PrintWriter pw = resp.getWriter();
        try {
            if (username.equals("admin") && password.equals("admin")) {
                employeeData ed = new employeeData();
                List<employee> list = null;
                try {
                    list = ed.fatchData();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("list", list);
                RequestDispatcher rd = req.getRequestDispatcher("employee.jsp");
                rd.forward(req, resp);
            } else {
                String url = "jdbc:mysql://localhost:3306/db";
                String user = "root";
                String pass = "root";
                Connection conn= DriverManager.getConnection(url,user,pass);
                    String sql = "SELECT username, password FROM logindata WHERE username = ?";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, username);
                    ResultSet resultSet = statement.executeQuery();
                    if(resultSet.next()){
                         String storedPassword = resultSet.getString("password");
                        if (storedPassword.equals(password)){
                            HttpSession session = req.getSession();
                            session.setAttribute("username",username);//session
                            session.setAttribute("password",password);//session
                            RequestDispatcher rd=req.getRequestDispatcher("userdata");
                            rd.forward(req,resp);
                        }
                        else{
                            pw.write("<h1>Incorrect Password</h1><input type='button' value='Go back!' onclick='history.back()'>");
                        }
                    }else{
                        pw.write("<h1>User Not Found</h1>" +
                                "   <a href=\"index.html\" ><button>signup</button></a>"+"<input type='button' value='Go back!' onclick='history.back()'>");


                    }
//                    if (resultSet.next()) {
//                        String storedusername= resultSet.getString("username");
//                        String storedPassword = resultSet.getString("password");
//                        if (username.equals(storedusername)&&password.equals(storedPassword)) {
//                            req.setAttribute("username",username);
//                            req.setAttribute("password",password);
//                            RequestDispatcher rd=req.getRequestDispatcher("userdata");
//                            rd.forward(req,resp);
//                         } else if (username.equals(storedusername)) {
//                            pw.write("<h1>password is incorrect</h1><input type=\"button\" value=\"Go back!\" onclick=\"history.back()\">");
//                        else if(password.equals(storedPassword)) {
//                    pw.write("<h1>username is incorrect</h1>" +
//                            "<form>\n" +
//                            "            <input type=\"button\" value=\"Go back!\" onclick=\"history.back()\">\n" +
//                            "        </form>");
//                }
//            }
        }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    }

