package payRoll;

import payRoll.dataLayer.Entities.DailyPay;
import payRoll.dataLayer.Entities.Employee;
import payRoll.dataLayer.Services.EmployeeOperations;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

class Payments{
	public static void main(String args[]){

		EmployeeOperations.addEmployee("Shishir", "8890609120", Constants.SalType.MONTHLY, 500000);
		EmployeeOperations.addEmployee("Himanshu", "8890609120", Constants.SalType.MONTHLY, 500000);
		EmployeeOperations.addEmployee("Kislay", "8890609120", Constants.SalType.DAILY, 10000);


		EmployeeOperations.deleteEmployee(1);

		ArrayList<Employee> employees = EmployeeOperations.getEmployees();

		System.out.println(employees.size());
		LocalDate today = LocalDate.now();
		EmployeeOperations.addDailyPay(new DailyPay(1,today ,10));
	}

	void addEmployee(){

	}
}