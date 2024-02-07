package org.car_rantel.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDAO {

    static final String dbURL = "jdbc:mysql://127.0.0.1:3306/car_rental";
    static final String user = "root";
    static final String pass = "12345678";

    static Connection conn;
    public BaseDAO() {
        try{
            conn = DriverManager.getConnection(dbURL, user, pass);
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
