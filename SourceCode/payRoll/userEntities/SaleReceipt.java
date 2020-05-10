package payRoll.userEntities;

import java.time.LocalDate;

public class SaleReceipt extends genericReceipt{
    private Integer itemID;
    private Employee employee;

    public SaleReceipt(LocalDate date, Integer amount, Integer itemID, Employee employee) {
        super(date, amount);
        this.itemID = itemID;
        this.employee = employee;
    }

    public Integer getItemID() {
        return itemID;
    }

    public Employee getEmployee() {
        return employee;
    }
}
