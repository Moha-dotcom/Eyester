package org.example;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Company{

    PreparedStatement preparestatement = null;
    Statement statement = null;
    DbConnection dbConnection = new DbConnection();

    public Company() throws SQLException, IOException {

    }




    public void getEmployeeInfo(Integer employeeid) throws SQLException {
        String findEmployeeById = "select * from EMPLOYEES\n" +
                "WHERE EMPLOYEES.empno = ? ";

        preparestatement = dbConnection.establishConnection().prepareStatement(findEmployeeById);
        preparestatement.setInt(1, employeeid);

        ResultSet resultSet = preparestatement.executeQuery();

        System.out.println("empno " + " \t\t" + "name" + " \t\t" + "job" + "\t\t" + "Manager" + "\t\t\t\t" + "Hire date" + "\t\t" +
                "Salary" + "\t\t" + "Commission" + "\t\t\t\t\t" + "deptNo");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        while (resultSet.next()){
            int empno = resultSet.getInt("empno");
            String name = resultSet.getString("name");
            String job = resultSet.getString("job");
            String Manager = resultSet.getString("manager");
            Date hiredate = resultSet.getDate("hiredate");
            int salary = resultSet.getInt("salary");
            int commision = resultSet.getInt("commission");
            int deptno = resultSet.getInt("deptno");

            System.out.println(empno + " \t\t" + name + " \t\t" + job + "\t\t" + Manager + "\t\t" + hiredate + "\t\t" +
                    salary + "\t\t\t" + commision + "\t\t\t\t" + deptno);

        }

//        return Optional.ofNullable();
    }



    public void ShowJoinedTables(String sql) throws SQLException {
        statement = dbConnection.establishConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Employee Name" + "\t\t" + "DeptName" + " \t\t\t\t" + "Job Title" + " \t\t\t\t\t" + "Location");
        System.out.println("--------------------------------------------------------------------------------------------");
        while (resultSet.next()){
            String empname = resultSet.getString("EmployeeName");
            String DeptName = resultSet.getString("name");
            String Jobtitle = resultSet.getString("Job");
            String loc = resultSet.getString("location");

            System.out.println(empname + " \t\t" + DeptName + "\t\t" + Jobtitle + "\t\t\t\t\t\t " + loc);

        }




    }


    public void createtabledatabase(String sql) {
        try {
            statement = dbConnection.establishConnection().createStatement();
            statement.execute(sql);

        }catch (SQLException e){
            System.err.println(e);
        }
    }

    public void addDepartment(Department department) throws SQLException {

        try{
            String sql = "insert into departments (deptno, name, location) values\n" +
                    "   (? ,?,?)";
            preparestatement = dbConnection.establishConnection().prepareStatement(sql);
            preparestatement.setInt(1,department.getDepartno());
            preparestatement.setString(2, department.getDepartmentName());
            preparestatement.setString(3, department.getDepartmentLoc());
            preparestatement.execute();
            preparestatement.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }


    public void addEmployee(Employee employee) throws SQLException {

        try {
            String sqldata = "insert into employees(empno , name, job, manager, hiredate, salary, commission, deptno) values\n" +
                    "(?,?,?,?,?,?,?,?)";
            preparestatement = dbConnection.establishConnection().prepareStatement(sqldata);
            preparestatement.setInt(1, employee.getEmpno());
            preparestatement.setString(2, employee.getEmpname());
            preparestatement.setString(3, employee.getJoddesc());
            preparestatement.setString(4, employee.getManager());
            preparestatement.setDate(5, Date.valueOf(employee.getDatehired()));
            preparestatement.setDouble(6, employee.getSalary());
            preparestatement.setDouble(7, employee.getCommission());
            preparestatement.setInt(8, employee.getDepartno());

            preparestatement.execute();

            preparestatement.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }


    public void PrintDepartmentTable() throws SQLException {
        String checkSql = "Select deptno, name, location from departments";
        statement  =dbConnection.establishConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(checkSql);

        System.out.println("DeptNo" + "\t\t" + "DeptName" + " \t\t\t\t" + "DeptLocation");
        System.out.println("------------------------------------------------------------");
        while (resultSet.next()){
            int id = resultSet.getInt("deptno");
            String name = resultSet.getString("name");
            String location = resultSet.getString("location");

            System.out.println(id + "\t\t" + name + " \t\t\t\t\t" + location);

        }

    }




}
