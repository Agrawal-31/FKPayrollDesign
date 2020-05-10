package payRoll.dataLayer.Entities;

import payRoll.Constants;

public class Employee extends Person{
	private Constants.SalType salType;
	private Integer salary;

	public Constants.SalType getSalType() {
		return salType;
	}

	public Employee(Integer id, String name, String phNo, Constants.SalType salType, Integer salary){
		super(id, name, phNo);
		this.salType = salType;
		this.salary = salary;
	}

	public String employeePrint(){
		return getName() + " " + salary;
	}

	public Integer getSalary(){
		return salary;
	}
}