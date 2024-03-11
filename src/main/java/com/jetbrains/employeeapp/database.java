//package com.jetbrains.employeeapp;
//
//import java.sql.*;
//
//public class database {
//    public void data() {
//        String url = "jdbc:mysql://localhost:3306/db";
//        String username = "root";
//        String password = "root";
//        String sql;
//        sql=
//
//        try (Connection conn = DriverManager.getConnection(url, username, password)) {
//            PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
