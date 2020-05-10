package payRoll;

import payRoll.dataLayer.Entities.DailyPay;
import payRoll.dataLayer.Entities.Employee;
import payRoll.dataLayer.Entities.SaleReceipt;
import payRoll.dataLayer.Services.EmployeeOperations;
import payRoll.dataLayer.Services.PayrollCalculator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

class Payments{
	public static void main(String args[]){

		Employee employee1 = EmployeeOperations.addEmployee("Shishir", "8890609120", Constants.SalType.MONTHLY, 500000);
		Employee employee2 = EmployeeOperations.addEmployee("Himanshu", "8890609120", Constants.SalType.MONTHLY, 500000);
		Employee employee3 = EmployeeOperations.addEmployee("Kislay", "8890609120", Constants.SalType.DAILY, 10000);

		EmployeeOperations.deleteEmployee(employee3.getId());

		ArrayList<Employee> employees = EmployeeOperations.getEmployees();
		System.out.println(employees.size());

		LocalDate today = LocalDate.of(2020, 5, 10);
		EmployeeOperations.addDailyPay(new DailyPay(employee1.getId(),today ,10));

		System.out.println(employee1.getId());
		SaleReceipt saleReceipt = new SaleReceipt(employee1.getId(), today, 500);
		EmployeeOperations.addSaleReceipt(saleReceipt);

		ArrayList<Integer> payableDays = EmployeeOperations.totalPayableHours(1);
		System.out.println(payableDays.size());

		Map<Employee, Integer> salaries =  PayrollCalculator.tillDateSalary(LocalDate.now());

		salaries.forEach((key, value) -> System.out.println(key.getName() + " : " + value));
	}

}