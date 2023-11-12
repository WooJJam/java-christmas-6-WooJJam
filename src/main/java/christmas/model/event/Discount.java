package christmas.model.event;

import christmas.model.Visit;
import christmas.model.Week;

public abstract class Discount {
    public int amount;

    public abstract void applyDiscount(Visit visit);


    public int getAmount() {
        return amount;
    }
}
