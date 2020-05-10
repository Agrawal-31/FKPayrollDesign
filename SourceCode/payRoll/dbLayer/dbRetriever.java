package payRoll.dbLayer;

import payRoll.Constants;
import payRoll.dataLayer.Entities.DailyPay;
import payRoll.dataLayer.Entities.Employee;
import payRoll.dataLayer.interfaces.DBMSCred;

import java.sql.*;

import java.util.ArrayList;

public class dbRetriever implements DBMSCred {
    private static Connection con;

    private static Connection getConnection(){
        try
        {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Employee> getEmployees(){
        if(con == null)
            con = getConnection();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try
        {
            String sql = "select * FROM employee_details";
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while(resultSet.next()){
                Employee employee = new Employee(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        Constants.SalType.valueOf(resultSet.getString(4)),
                        resultSet.getInt(5)
                );
                employees.add(employee);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return employees;
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

    public static boolean addDailyPay(DailyPay day){
        if(con == null)
            con = getConnection();
        try
        {
            String sql = "insert into daily_pay values("+day.getId()+",'"+day.getDate()+"',"+day.getHours()+")";
            Statement st = con.createStatement();
            int m = st.executeUpdate(sql);
            if (m == 1) {
                System.out.println("Day details Added successfully : " + sql);
                return true;
            }else
                System.out.println("Day details addition failed");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return false;
        }
        return false;
    }


}
