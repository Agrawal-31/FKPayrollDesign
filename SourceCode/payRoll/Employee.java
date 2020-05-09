package payRoll;

class Employee extends Person{
	private Constants.SalType salType;
	private Integer salary;

	Employee(String name, String phNo, Constants.SalType salType, Integer salary){
		super(name, phNo);
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