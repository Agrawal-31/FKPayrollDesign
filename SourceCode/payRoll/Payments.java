package payRoll;

import java.util.ArrayList;

class Payments{
	public static void main(String args[]){

		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Shishir", "8890609120", Constants.SalType.MONTHLY, 500000));
		employees.add(new Employee("Himanshu", "8890609120", Constants.SalType.MONTHLY, 500000));
		employees.add(new Employee("Kislay", "8890609120", Constants.SalType.DAILY, 10000));

		int sum = 0;
		for (Employee employee: employees){
			sum += employee.getSalary();
		}

		System.out.println(sum);
	}

	void addEmployee(){
		
	}
}