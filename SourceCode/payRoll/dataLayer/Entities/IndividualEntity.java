package payRoll.dataLayer.Entities;

import java.time.LocalDate;

public class IndividualEntity {
    private Integer id;
    private LocalDate date;

    public IndividualEntity(Integer id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }
}
