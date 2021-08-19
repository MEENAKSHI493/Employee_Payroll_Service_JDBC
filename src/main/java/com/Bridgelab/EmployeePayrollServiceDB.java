package com.Bridgelab;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;

public class EmployeePayrollServiceDB {
    public static void main(String[] args) throws SQLException {
        System.out.println("welcome to  JDBC connection");
        //establishConnectiontoDB();
        EmployeePayrollServiceDB empdb = new EmployeePayrollServiceDB();
        empdb.getEmployeeData();

    }
       /**
        *   Method to establish Connect to JDBC
        **/
    public Connection establishConnectiontoDB() {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?userSSL=false";
        String username = "root"; // my SQL username
        String password = "Root"; // my sql password

        Connection connection = null;
        try {
            System.out.println("Connecting to database :" + jdbcURL);
            // connecting driver to jdbc
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Successfully connected to database!:" + connection);
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Database connected Successfully");
        }
        listDrivers();
        return connection;
    }

        //To List all the drivers
        private static void listDrivers() {
            Enumeration<Driver> driverList = DriverManager.getDrivers();
            while (driverList.hasMoreElements()) {
                System.out.println(driverList.nextElement());
            }
        }

    public ArrayList<EmpPayrollData> getEmployeeData() {
   
        String sql = "SELECT * from employee_payroll";
        ArrayList<EmpPayrollData> empPayrollData = new ArrayList<>();
        try {
            Connection con = this.establishConnectiontoDB();
            Statement st = con.createStatement();
            ResultSet resset = st.executeQuery(sql);
            while (resset.next()) {
                System.out.println("**********************");
                int id = resset.getInt("id");
                System.out.println("EmployeeID::" + id);
                String name = resset.getString("name");
                System.out.println("EmployeeName::" + name);
                String gender = resset.getString("gender");
                System.out.println("Gender::" + gender);
                double BasicPay = resset.getDouble("salary");
                System.out.println("Basic Salary::" + BasicPay);
                LocalDate startDate = resset.getDate("start").toLocalDate();//toLocalDaArrayList<EmpPayrollData> empPayrollDatate();
                System.out.println("startDate::" + startDate);
                empPayrollData.add(new EmpPayrollData(id, name, gender, startDate, BasicPay));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return empPayrollData;
    }
}
