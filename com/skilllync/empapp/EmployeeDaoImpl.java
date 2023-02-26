package com.skilllync.empapp;

import java.sql.Statement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDaoImpl implements EmployeeDaoIntrf {
    Connection con;

    @Override
    public void createEmployee(Employee emp) {

        con = DBconnection.createDBConnection();
        String query = "insert into employee values(?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getName());
            pstmt.setDouble(3, emp.getSalary());
            pstmt.setInt(4, emp.getAge());

            int x = pstmt.executeUpdate();
            if (x > 0) {
                System.out.println("Employee Inserted Successfully !!!");

            } else {
                System.out.println("Not Inserted successfully ");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void showAllEmployee() {
        con = DBconnection.createDBConnection();
        String query = "Select * from employee";
        System.out.println("\n\nEmployee Details :");
        System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Salary", "age");
        System.out.println("--------------------");

        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d   %s   %8.2f   %d \n", result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("-------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnId(int id) {
        // TODO Auto-generated method stub
        con = DBconnection.createDBConnection();
        String querry = "Select * from employee where id = " + id;
        System.out.println("\n\nEmployee Details :");
        System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Salary", "age");
        System.out.println("--------------------");

        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(querry);
            while (result.next()) {
                System.out.format("%d   %s   %8.2f   %d \n", result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("-------------------");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBconnection.createDBConnection();
        String querry = "Update employee set name = ? where id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(querry);
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            int x = pstmt.executeUpdate();
            if (x != 0) {
                System.out.println("Employee UPDATED Successfully !!!");

            } else {
                System.out.println("Not UPDATED successfully ");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Override
    public void deleteEmployee(int id) {
        con = DBconnection.createDBConnection();
        String querry = "Delete from employee where id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(querry);
            pstmt.setInt(1, id);
            int x = pstmt.executeUpdate();
            if (x > 0) {
                System.out.println("Employee Deleted Successfully !!!");

            } else {
                System.out.println("Not Deleted successfully ");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteAllEmployee() {
        con = DBconnection.createDBConnection();
        String querry = "Delete from employee";
        try {
            Statement stmt = con.createStatement();
            int x = stmt.executeUpdate(querry);
            if (x > 0) {
                System.out.println("Deleted all the employees successfully!!!");
            } else {
                System.out.println("Not able to delete the employess, try again");
            }

        } catch (Exception eK) {
            eK.printStackTrace();
        }
    }

}
