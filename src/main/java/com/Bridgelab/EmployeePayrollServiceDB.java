package com.Bridgelab;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class EmployeePayrollServiceDB {
  //  private static Object SQLException;
    //private static Object ClassNotFoundException;

    public static void main(String[] args) throws SQLException {
        System.out.println("welcome to  JDBC connection");
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?userSSL=false";
        String username = "root" ;
        String password = "Root" ;

        Connection connection;
        try {
            System.out.println("Connecting to database :" + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Successfully connected to database!:" + connection);
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        }
        catch(SQLException  e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Database connected Successfully");
        }
        listDrivers();

    }

    //To List all the drivers
    private static void listDrivers(){
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements()){
            System.out.println(driverList.nextElement());
        }
    }
}
