package com.skilllync.empapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        System.out.println("Welcome to employee management System");

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\n1. Add Employee\n" +
                    "2. Show All Employee\n" +
                    "3. show Employee based on id\n" +
                    "4. Update the employee\n" +
                    "5. Delete the employee\n" +
                    "6. Delete All employees\n" +
                    "7. Exit");
            System.out.print("Enter choise: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Employee emp = new Employee();
                    System.out.println("\n\nEnter Id :");
                    int id = sc.nextInt();
                    System.out.println("Enter name : ");
                    String name = sc.next();
                    System.out.println("Enter Salary : ");
                    double salary = sc.nextDouble();
                    System.out.println("Enter age : ");
                    int age = sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployee(emp);

                    break;

                case 2:
                    dao.showAllEmployee();
                    break;

                case 3:
                    System.out.print("\n\nEnter the employe id to show details : ");
                    int empid = sc.nextInt();
                    dao.showEmployeeBasedOnId(empid);
                    break;
                case 4:
                    System.out.print("\n\nEnter id to update the details : ");
                    int empid_for_update = sc.nextInt();
                    System.out.print("Enter the updated name : ");
                    String updated_name = sc.next();
                    dao.updateEmployee(empid_for_update, updated_name);
                    break;
                case 5:
                    System.out.print("\n\nEnter the employe id to delete the employee : ");
                    int empid_for_Delete = sc.nextInt();
                    dao.deleteEmployee(empid_for_Delete);
                    break;
                case 6:
                    System.out.println("Clearing all details of the for all the employee");
                    dao.deleteAllEmployee();
                    break;
                case 7:
                    System.out.println("\n\nThanku for using our Application !!!");
                    System.exit(0);
                default:
                    System.out.println("\n\nEnter valid choise ");
                    break;
            }
        
        } while (true);
    }
}
