package payRoll;

import payRoll.dataLayer.dbEntities.DailyPay;
import payRoll.dataLayer.dbEntities.Employee;
import payRoll.dataLayer.dbEntities.SaleReceipt;
import payRoll.dataLayer.Services.EmployeeOperations;
import payRoll.dataLayer.Services.PayrollCalculator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

class Payments{
	public static void main(String args[]){

		Employee employee1 = EmployeeOperations.addEmployee("Shishir", "8890609120", Constants.SalType.MONTHLY, 500000);
		Employee employee2 = EmployeeOperations.addEmployee("Himanshu", "8890609120", Constants.SalType.DAILY, 500000);
		Employee employee3 = EmployeeOperations.addEmployee("Kislay", "8890609120", Constants.SalType.DAILY, 10000);

		EmployeeOperations.deleteEmployee(employee3.getId());

		ArrayList<Employee> employees = EmployeeOperations.getEmployees();
		System.out.println(employees.size());

		EmployeeOperations.addDailyPay(new DailyPay(employee1.getId(),LocalDate.now() ,10));

		System.out.println(employee1.getId());
		SaleReceipt saleReceipt = new SaleReceipt(employee1.getId(), LocalDate.now(), 500);
		EmployeeOperations.addSaleReceipt(saleReceipt);

		Map<Employee, Integer> salaries =  PayrollCalculator.tillDateSalary(LocalDate.now());

		salaries.forEach((key, value) -> System.out.println(key.getName() + " : " + value));
	}

}