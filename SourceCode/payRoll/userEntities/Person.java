package payRoll.userEntities;

import java.util.Random;

public class Person{
	private static int lastId;
	private Integer id;
	private String name;
	private String phNo;

	Person(Integer id, String name, String phNo){
		this.id = id;
		this.name = name;
		this.phNo = phNo;
	}

	public String getPhNo() {
		return phNo;
	}

	public String getName(){
		return name;
	}
	public Integer getId(){
		return id;
	}

}