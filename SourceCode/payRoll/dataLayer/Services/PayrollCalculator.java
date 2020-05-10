package payRoll.dataLayer.Services;

import payRoll.Constants;
import payRoll.dataLayer.dbEntities.Employee;
import payRoll.dbLayer.dbRetriever;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PayrollCalculator {
    public static Map<Employee, Integer> tillDateSalary(LocalDate tillDate){
        ArrayList<Employee> employees = EmployeeOperations.getEmployees();
        Map<Employee, Integer> employeePayHashMap = new HashMap<Employee, Integer>();
        for(Employee employee: employees){
            Integer pay;
            if(employee.getSalType() == Constants.SalType.DAILY){
                pay = daywiseEmployeeSalary(employee);
            }else{
                pay = monthlyEmployeeSalary(employee);
            }
            employeePayHashMap.put(employee, pay);
        }
        return employeePayHashMap;
    }

    public static Integer daywiseEmployeeSalary(Employee employee){
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
        return totalPay.intValue();
    }

    public static Integer monthlyEmployeeSalary(Employee employee){
        LocalDate lastPaymentDate = dbRetriever.lastPaidOn(employee.getId());
        Period intervalPeriod = Period.between(lastPaymentDate, LocalDate.now());
        Integer salaryDue = intervalPeriod.getMonths();
        return employee.getSalary()*salaryDue;
    }
}
