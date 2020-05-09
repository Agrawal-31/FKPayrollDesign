package payRoll.dbLayer;

import payRoll.dataLayer.Entities.Employee;
import java.sql.*;

import java.util.ArrayList;

public class dbRetriever {
    private static ArrayList<Employee> employees;
    private static Connection con;
    private static String URL = "jdbc:mysql://localhost:3306/flipkartproject";
    private static String USER = "root";
    private static String PASS = "root";


    private static Connection getConnection(){
        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            return DriverManager.getConnection(URL,USER,PASS);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Employee> getEmployees(){
        if(con != null) {
            return employees;
        }else {
            return new ArrayList<Employee>();
        }
    }

    public static boolean addEmployee(Employee employee){
        if(con == null)
            con = getConnection();

        try
        {
            String sql = "insert into employee_details values("+employee.getId()+",'"+employee.getName()+"','"+employee.getPhNo()+"','"+employee.getSalType()+"',"+ employee.getSalary()+")";
            Statement st = con.createStatement();
            int m = st.executeUpdate(sql);
            if (m == 1) {
                System.out.println("inserted successfully : " + sql);
                return true;
            }else
                System.out.println("insertion failed");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return false;
        }
        return false;
    }

    public static boolean deleteEmployee(int empId){
        if(con == null)
            con = getConnection();
        try
        {
            String sql = "delete from employee_details where id =" + empId;
            Statement st = con.createStatement();
            int m = st.executeUpdate(sql);
            if (m == 1) {
                System.out.println("Deleted successfully : " + sql);
                return true;
            }else
                System.out.println("Deletion failed");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return false;
        }
        return false;
    }

}
