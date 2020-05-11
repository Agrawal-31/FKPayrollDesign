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
		//Employee employee2 = EmployeeOperations.addEmployee("Himanshu", "8890609120", Constants.SalType.DAILY, 500000);
		Employee employee3 = EmployeeOperations.addEmployee("Kislay", "8890609120", Constants.SalType.DAILY, 10000);

		EmployeeOperations.deleteEmployee(employee3.getId());

		EmployeeOperations.addDailyPay(new DailyPay(employee1.getId(),LocalDate.now() ,10));

		EmployeeOperations.updateEmployee(employee1.getId(), employee1.getName(), employee1.getPhNo(), employee1.getSalType(), 40000);

		SaleReceipt saleReceipt = new SaleReceipt(employee1.getId(), LocalDate.now(), 500);
		EmployeeOperations.addSaleReceipt(saleReceipt);

		PayrollCalculator.paySalaries();
	}

}