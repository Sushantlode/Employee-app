package com.jetbrains.employeeapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class employeeData {
    public List<employee> fatchData() throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/db";
        String username = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "select * from logindata";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<employee> list=new ArrayList<>();
            while (rs.next())
            {
                int id=rs.getInt("id");
                String name=rs.getString("username");
                String city=rs.getString("city");
                employee e=new employee();
                e.setId(id);
                e.setName(name);
                e.setCity(city);
                list.add(e);
            }

            return list;
        }
    }
}
