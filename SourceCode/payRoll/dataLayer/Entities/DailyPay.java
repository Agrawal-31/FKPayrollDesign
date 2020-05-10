package payRoll.dataLayer.Entities;

import java.time.LocalDate;
import java.util.Date;

public class DailyPay {
    private Integer id;
    private LocalDate date;
    private Integer hours;

    public DailyPay(Integer id, LocalDate date, Integer hours) {
        this.id = id;
        this.date = date;
        this.hours = hours;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getHours() {
        return hours;
    }
}
