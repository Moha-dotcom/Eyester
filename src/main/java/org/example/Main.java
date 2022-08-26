package org.example;



import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

        try{
            DbConnection databaseConnection = new DbConnection();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

        Department department = new Department(923, "Coffee Mar", "Golden Valley, Mn");
        Department development = new Department(123, "Development", "Boston, MA");
        Department IosDepartment = new Department(13, "Ios Department", "Boston, MA");
        Department research_department = new Department(1, "Research Department", "Austin, Tx");

        Department CyberSecurity = new Department(2, "Cyber Security ", "Lewistin, MA");
        Employee employee = new Employee(3, "Mohamed Abdullahi", "SoftWare Enginner", "William John", LocalDate.of(2022,8,1), 59000, 12000,
                2);

        Employee employee2 = new Employee(1, "Sam Smith", "SoftWare Enginner", "William John", LocalDate.of(2020,8,1), 59000, 12000,
                2);

        Employee employee3 = new Employee(9, "Mara Smith", "Analyst", "Sam Smith", LocalDate.of(2005,8,1), 94000, 9000,
                2);

        Employee employee4 = new Employee(16, "Yun Yates", "Analyst", "Sam Smith", LocalDate.of(2005,8,1), 94000, 9000,
                13);

        Employee employee5 = new Employee(12, "Mustafa Ismail", "Customer Service", "John Makeel", LocalDate.of(2002,8,1), 105000, 11000,
                329);

        Employee employee6 = new Employee(10, "Ahmed Yusuf", "Customer Service", "John Makeel", LocalDate.of(2002,8,1), 105000, 11000,
                923);



//        DepartmentService service = new DepartmentService();
//        service.addDepartment(IosDepartment);
//13
//        // Prints Tables
//        service.PrintDepartmentTable();


        Company company = new Company();
//        company.addDepartment(CyberSecurity);
        company.PrintDepartmentTable();
        company.addEmployee(employee6);
        String sqlShowJoinedaTable = "select e.name EmployeeName,\n" +
                "           d.name ,\n" +
                "           e.job,\n" +
                "           d.location\n" +
                "from departments d, employees e\n" +
                "where e.deptno = d.deptno\n" +
                "ORDER BY e.name";
        company.ShowJoinedTables(sqlShowJoinedaTable);
//        String sql = "create table EMPLOYEES (  \n" +
//                "  empno             INT,  \n" +
//                "  name              varchar(50) not null,  \n" +
//                "  job               varchar(50),  \n" +
//                "  manager           varchar(50),  \n" +
//                "  hiredate          date,  \n" +
//                "  salary            INT,  \n" +
//                "  commission        INT,  \n" +
//                "  deptno           INT,  \n" +
//                "  constraint pk_employees primary key (empno),  \n" +
//                "  constraint fk_employees_deptno foreign key (deptno) \n" +
//                "      references DEPARTMENTS (deptno)  \n" +
//                ")";
//        company.createtabledatabase(sql);



        company.getEmployeeInfo(12);



    }
}
