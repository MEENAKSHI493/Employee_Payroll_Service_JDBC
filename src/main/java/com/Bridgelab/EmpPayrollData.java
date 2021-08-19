package com.Bridgelab;

import java.time.LocalDate;

public class EmpPayrollData {
    private int id;
    private String name;
    private String gender;
    private double salary;
    private LocalDate start;
    //Constructor
    public EmpPayrollData(int id, String name, String gender, LocalDate start,double salary){
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.start=start;
        this.salary=salary;
    }
     //  getter /setter method to pass the variables
    public int getId(){
        return  this.id;
    }
    public String getName(){
        return this.name;
    }
    public  String getGender(){
        return this.gender;
    }
    public double getSalary(){
        return this.salary;
    }

    public LocalDate getStart(){
        return this.start;
    }
}
