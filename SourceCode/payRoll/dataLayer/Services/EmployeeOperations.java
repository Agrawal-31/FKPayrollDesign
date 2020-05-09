package payRoll.dataLayer.Services;

import payRoll.Constants;
import payRoll.dataLayer.Entities.Employee;
import payRoll.dataLayer.interfaces.CRUDOperations;
import payRoll.dbLayer.dbRetriever;

import java.util.ArrayList;

public class EmployeeOperations {

    public static void addEmployee(String name, String phNo, Constants.SalType salType, Integer salary){
        Employee employee = new Employee(name, phNo, salType, salary);
        ArrayList<Employee> employees = dbRetriever.getEmployees();
        System.out.println("Added");
        employees.add(employee);
    }

    public static boolean deleteEmployee(Integer id){
        ArrayList<Employee> employees = dbRetriever.getEmployees();
        System.out.println("Deleted");
         return employees.removeIf(employee -> employee.getId() == id);
    }

}


