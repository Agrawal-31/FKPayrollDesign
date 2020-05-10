package payRoll.dataLayer.Services;

import payRoll.Constants;
import payRoll.dataLayer.Entities.DailyPay;
import payRoll.dataLayer.Entities.Employee;
import payRoll.dataLayer.Entities.Person;
import payRoll.dataLayer.Entities.SaleReceipt;
import payRoll.dbLayer.dbRetriever;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeOperations {

    public static Employee addEmployee(String name, String phNo, Constants.SalType salType, Integer salary){
        Employee employee = new Employee(Person.idGenerator(), name, phNo, salType, salary);
        dbRetriever.addEmployee(employee);
        System.out.println("Added");
        return employee;
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

    public static ArrayList<Integer> totalPayableHours(Integer id){
        LocalDate tillPaidDate = dbRetriever.lastPaidOn(id);
        ArrayList<Integer> remDays = dbRetriever.payableHoursInRange(id, tillPaidDate, LocalDate.now());
        return remDays;
    }
}


