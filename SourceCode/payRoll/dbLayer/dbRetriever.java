package payRoll.dbLayer;

import payRoll.Constants;
import payRoll.dataLayer.dbEntities.DailyPay;
import payRoll.dataLayer.dbEntities.Employee;
import payRoll.dataLayer.dbEntities.SaleReceipt;
import payRoll.dataLayer.interfaces.DBMSCred;

import java.sql.*;

import java.time.LocalDate;
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
                        resultSet.getInt(1),
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

    public static boolean addSaleReceipt(SaleReceipt saleReceipt){
        if(con == null)
            con = getConnection();
        try
        {
            String sql = "insert into sales_receipt values("+saleReceipt.getId()+",'"+saleReceipt.getDate()+"',"+saleReceipt.getAmount()+")";
            Statement st = con.createStatement();
            int m = st.executeUpdate(sql);
            if (m == 1) {
                System.out.println("Sale Receipt Added successfully : " + sql);
                return true;
            }else
                System.out.println("Sale Receipt addition failed");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return false;
        }
        return false;
    }


    public static ArrayList<Integer> payableHoursInRange(Integer empId, LocalDate fromDate, LocalDate toDate){
        if(con == null)
            con = getConnection();

        ArrayList<Integer> payableHours = new ArrayList<>();
        try
        {
            String sql = "select hours FROM daily_pay where (date BETWEEN '"+fromDate+"' AND '"+toDate+"') AND id="+empId;
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while(resultSet.next()){
                payableHours.add(resultSet.getInt(1));
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return payableHours;
    }

    public static LocalDate lastPaidOn(int empId){
        if(con == null)
            con = getConnection();

       LocalDate localDate = Constants.Dates.beginningDate;

        try
        {
            String sql = "select date from salary_transactions where date = (SELECT MAX(date) from salary_transactions where id =" + empId + ")";
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            if(resultSet.next()) {
                localDate = resultSet.getDate(1).toLocalDate();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);

        }
        return localDate;
    }

    public static boolean addSalaryTransaction(Integer empId, LocalDate payDate, LocalDate salesComDate){
        if(con == null)
            con = getConnection();
        try
        {
            String sql = "insert into salary_transactions values("+empId+",'"+payDate+"','"+salesComDate+"')";
            Statement st = con.createStatement();
            int m = st.executeUpdate(sql);
            if (m == 1) {
                System.out.println("Salary transaction Added successfully : " + sql);
                return true;
            }else
                System.out.println("Salary transaction addition failed");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return false;
        }
        return false;
    }


}
