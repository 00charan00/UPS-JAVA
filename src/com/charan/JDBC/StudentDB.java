package com.charan.JDBC;
import java.sql.*;
import java.util.*;

public class StudentDB {
    private static Connection conn;

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(conn);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String dbUrl = "jdbc:mysql://localhost:3306/jdbc";
            String dbUser = "root";
            String dbPass = "1030";

            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            System.out.println("Connection Successful!");
            System.out.println(conn);

            boolean exit = false;
            while (!exit) {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Insert Record");
                System.out.println("2. View Records");
                System.out.println("3. Update Record");
                System.out.println("4. Delete Record");
                System.out.println("5. Exit");
                System.out.println("6. Transaction");
                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        insertRecord();
                        break;
                    case 2:
                        selectRecord();
                        break;
                    case 3:
                        updateRecord();
                        break;
                    case 4:
                        deleteRecord();
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    case 6:
                        transaction();
                        break;
                    default:
                        System.out.println("Please enter a valid choice.");
                }
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
        String sql = "SELECT * FROM studentjdbc";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            int roll = result.getInt("roll");
            String name = result.getString("name");
            double percentage = result.getDouble("percentage");
            String address = result.getString("address");
            System.out.println("Roll: " + roll + " | Name: " + name + " | Percentage: " + percentage + " | Address: " + address);
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

    private static void deleteRecord() throws SQLException {
        System.out.print("Enter rollno to delete the record: ");
        int roll = sc.nextInt();
        sc.nextLine();

        String sql = "DELETE FROM studentjdbc WHERE roll = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, roll);

        int row = preparedStatement.executeUpdate();
        if (row > 0) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("No record found with roll number: " + roll);
        }
    }


    public static void transaction() throws SQLException {
        conn.setAutoCommit(false);

        String sql1 = "insert into studentjdbc (name, percentage, address) values ('Anshalin', '98', 'Nagercoil')";
        String sql2 = "UPDATE studentjdbc SET name='shaaruuu' WHERE percentage=98";
        PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
        int row1 = preparedStatement1.executeUpdate();

        PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
        int row2 = preparedStatement2.executeUpdate();

        if (row1 > 0 && row2 > 0) {
            conn.commit();
            System.out.println("Transaction successful.");
        } else {
            conn.rollback();
            System.out.println("Transaction failed and rolled back.");
        }


    }


}
