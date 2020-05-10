package payRoll.dataLayer.dbEntities;

import java.time.LocalDate;

public class DailyPay extends IndividualEntity{

    private Integer hours;

    public DailyPay(Integer id, LocalDate date, Integer hours) {
        super(id, date);
        this.hours = hours;
    }

    public Integer getHours() {
        return hours;
    }
}
