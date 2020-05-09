package payRoll;

import payRoll.dataLayer.Entities.Employee;
import payRoll.dataLayer.Services.EmployeeOperations;

import java.util.ArrayList;

class Payments{
	public static void main(String args[]){

		EmployeeOperations.addEmployee("Shishir", "8890609120", Constants.SalType.MONTHLY, 500000);
		EmployeeOperations.addEmployee("Himanshu", "8890609120", Constants.SalType.MONTHLY, 500000);
		EmployeeOperations.addEmployee("Kislay", "8890609120", Constants.SalType.DAILY, 10000);


		EmployeeOperations.deleteEmployee(1);

	}

	void addEmployee(){

	}
}