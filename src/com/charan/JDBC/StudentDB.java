package com.charan.JDBC;
import java.sql.*;
import java.util.Scanner;

public class StudentDB {
    private static Connection conn = null;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentDB studentDB = new StudentDB();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String dbUrl = "jdbc:mysql://localhost:3306/jdbc";
            String dbUser = "root";
            String dbPass = "1030";

            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            System.out.println("Connection Successful!");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }
}
