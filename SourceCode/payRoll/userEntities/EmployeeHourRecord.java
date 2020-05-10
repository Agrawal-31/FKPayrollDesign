package payRoll.userEntities;

import java.util.ArrayList;

public class EmployeeHourRecord {
    private Employee employee;
    private ArrayList<DailyPay> dailyPayArrayList;

    public EmployeeHourRecord(Employee employee) {
        this.employee = employee;
        this.dailyPayArrayList = new ArrayList<DailyPay>();
    }
}
