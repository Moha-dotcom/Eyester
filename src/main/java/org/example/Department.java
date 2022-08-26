package org.example;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Department {


    private int departno;
    private String departmentName;
    private String departmentLoc;

    public Department(int departno, String departmentName, String departmentLoc) throws SQLException, IOException {
        this.departno = departno;
        this.departmentName = departmentName;
        this.departmentLoc = departmentLoc;
    }

    public int getDepartno() {
        return departno;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentLoc() {
        return departmentLoc;
    }


}
