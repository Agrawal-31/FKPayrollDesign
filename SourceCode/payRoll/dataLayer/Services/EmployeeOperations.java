package payRoll.dataLayer.Services;

import payRoll.Constants;
import payRoll.dataLayer.Entities.DailyPay;
import payRoll.dataLayer.Entities.Employee;
import payRoll.dataLayer.Entities.SaleReceipt;
import payRoll.dataLayer.interfaces.CRUDOperations;
import payRoll.dbLayer.dbRetriever;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeOperations {

    public static void addEmployee(String name, String phNo, Constants.SalType salType, Integer salary){
        Employee employee = new Employee(name, phNo, salType, salary);
        dbRetriever.addEmployee(employee);
        System.out.println("Added");
    }

    public static void deleteEmployee(Integer id){
        dbRetriever.deleteEmployee(id);
        System.out.println("Deleted");
    }

    public static ArrayList<Employee> getEmployees(){
        return dbRetriever.getEmployees();
    }

    public  static void addDailyPay(DailyPay dayPay){
        dbRetriever.addDailyPay(dayPay);
    }

    public  static void addSaleReceipt(SaleReceipt saleReceipt){
        dbRetriever.addSaleReceipt(saleReceipt);
    }
}


