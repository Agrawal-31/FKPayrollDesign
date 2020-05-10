package payRoll.dataLayer.Services;

import payRoll.dataLayer.Entities.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PayrollCalculator {
    public static Map<Employee, Integer> tillDateSalary(LocalDate tillDate){
        ArrayList<Employee> employees = EmployeeOperations.getEmployees();
        Map<Employee, Integer> employeePayHashMap = new HashMap<Employee, Integer>();
        for(Employee employee: employees){
            ArrayList<Integer> employeeHours = new ArrayList<>();
            employeeHours = EmployeeOperations.totalPayableHours(employee.getId());
            Integer employeeId = employee.getId();
            Double totalPay = 0.0;
            for(Integer hours: employeeHours){
                Double pay = hours.doubleValue();
                if(hours > 8){
                    pay = 8.0 + (hours - 8)*1.5;
                }
                pay *= employee.getSalary();
                totalPay += pay;
            }
            totalPay = Math.ceil(totalPay);
            employeePayHashMap.put(employee, totalPay.intValue());
        }
        return employeePayHashMap;
    }
}
