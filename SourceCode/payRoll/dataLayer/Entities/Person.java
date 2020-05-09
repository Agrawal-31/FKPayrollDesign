package payRoll.dataLayer.Entities;

public class Person{
	private static int lastId;
	private Integer id;
	private String name;
	private String phNo;

	Person(String name, String phNo){
		id = ++lastId;
		this.name = name;
		this.phNo = phNo;
	}

	public String getName(){
		return name;
	}
	public Integer getId(){
		return id;
	}
}