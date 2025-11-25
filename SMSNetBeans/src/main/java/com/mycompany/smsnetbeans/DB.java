package com.mycompany.smsnetbeans;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private static final String URL = "jdbc:mysql://localhost:3306/sms?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "1234S@mi"; // change to your password

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
