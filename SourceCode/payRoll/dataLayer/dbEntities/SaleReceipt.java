package payRoll.dataLayer.Entities;

import java.time.LocalDate;

public class SaleReceipt extends IndividualEntity{
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public SaleReceipt(Integer id, LocalDate date, Integer amount) {
        super(id, date);
        this.amount = amount;
    }
}
