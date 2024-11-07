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

            System.out.print("Enter Choice: ");
            int choice= sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:insertRecord();
                       break;
                case 2:selectRecord();
                        break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }


        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }


    private static void insertRecord() throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter percentage: ");
        double percentage = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter address: ");
        String address = sc.nextLine();

        String sql = "INSERT INTO studentjdbc (name, percentage, address) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setDouble(2, percentage);
        preparedStatement.setString(3, address);

        int row = preparedStatement.executeUpdate();
        if (row > 0) {
            System.out.println("Record inserted successfully.");
        }
    }
    private static void selectRecord() throws SQLException {
        System.out.println("inside select");
//        int id= sc.nextInt();
//        sc.nextLine();
//        String sql="select * from studentjdbc where roll="+id;
        String sql="select * from studentjdbc";
        Statement statement=conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            int rolln= result.getInt("roll");
            String names= result.getString("name");
            int percent= result.getInt("percentage");
            String addresss= result.getString("address");
            System.out.println("Roll: "+rolln+" Name: "+names+" Percentage: "+percent+" Address: "+addresss);
        }
    }
}
