package christmas.model.event;

import christmas.constant.EventConstant;

public abstract class Discount implements EventConstant {
    public int amount = DISCOUNT_INITIAL_AMOUNT;

    public int getAmount() {
        return amount;
    }
}
