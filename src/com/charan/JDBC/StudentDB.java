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

                case 3:updateRecord();
                       break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }


        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }

    public static void updateRecord() throws SQLException {
        System.out.print("Enter rollno to update the record: ");
        int roll = sc.nextInt();
        sc.nextLine();

        String sql = "SELECT * FROM studentjdbc WHERE roll = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, roll);
        ResultSet res = preparedStatement.executeQuery();

        if (res.next()) {
            System.out.println("Current Record - Name: " + res.getString("name") + " | Percentage: " + res.getDouble("percentage") + " | Address: " + res.getString("address"));
            System.out.println("Choose the field to update: 1. Name 2. Percentage 3. Address");
            int choice = sc.nextInt();
            sc.nextLine();

            String updateField = "";
            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    updateField = "name";
                    break;
                case 2:
                    System.out.print("Enter new percentage: ");
                    updateField = "percentage";
                    break;
                case 3:
                    System.out.print("Enter new address: ");
                    updateField = "address";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            String newValue = sc.nextLine();
            sql = "UPDATE studentjdbc SET " + updateField + " = ? WHERE roll = ?";
            preparedStatement = conn.prepareStatement(sql);

            if (updateField.equals("percentage")) {
                preparedStatement.setDouble(1, Double.parseDouble(newValue));
            } else {
                preparedStatement.setString(1, newValue);
            }
            preparedStatement.setInt(2, roll);

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Record updated successfully.");
            }
        } else {
            System.out.println("No record found with roll number: " + roll);
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





