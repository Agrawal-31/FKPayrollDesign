package payRoll.dataLayer.Entities;

import java.time.LocalDate;
import java.util.Date;

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
