package payRoll.dbLayer;

import payRoll.dataLayer.Entities.Employee;

import java.util.ArrayList;

public class dbRetriever {
    private static ArrayList<Employee> employees;

    public static ArrayList<Employee> getEmployees(){
        if(employees != null) {
            return employees;
        }else {
            return new ArrayList<Employee>();
        }
    }

}
