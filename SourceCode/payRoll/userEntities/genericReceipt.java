package payRoll.userEntities;

import java.time.LocalDate;

public class genericReceipt {
    private LocalDate date;
    private Integer amount;

    public genericReceipt(LocalDate date, Integer amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getAmount() {
        return amount;
    }
}
