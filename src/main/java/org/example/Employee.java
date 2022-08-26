package org.example;


import java.time.LocalDate;

public class Employee {

    private int empno;
    private String empname;
    private String joddesc;
    private String manager;
    private LocalDate datehired;
    private double salary;
    private double commission;
    private int departno;


    public Employee(int empno, String empname, String joddesc, String manager, LocalDate datehired, double salary, double commission, int departno) {
        this.empno = empno;
        this.empname = empname;
        this.joddesc = joddesc;
        this.manager = manager;
        this.datehired = datehired;
        this.salary = salary;
        this.commission = commission;
        this.departno = departno;
    }

    public int getEmpno() {
        return empno;
    }

    public String getEmpname() {
        return empname;
    }

    public String getJoddesc() {
        return joddesc;
    }

    public String getManager() {
        return manager;
    }

    public LocalDate getDatehired() {
        return datehired;
    }

    public double getSalary() {
        return salary;
    }

    public double getCommission() {
        return commission;
    }

    public int getDepartno() {
        return departno;
    }
}
