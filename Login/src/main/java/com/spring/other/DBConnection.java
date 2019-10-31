package com.spring.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection con=null;
    private static DBConnection instance=null;
    private DBConnection(){}

    public static DBConnection getInstance(){
        if (instance== null){
            instance = new DBConnection();
        }
        return instance;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (con==null || con.isClosed()){
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            System.out.println("connected");
        }
        return con;
    }
}
