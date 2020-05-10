package payRoll.userEntities;

import java.time.LocalDate;

public class DailyPay{
    private LocalDate workDate;
    private Integer hours;

    public DailyPay(LocalDate workDate, Integer hours) {
        this.workDate = workDate;
        this.hours = hours;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public Integer getHours() {
        return hours;
    }
}
