package christmas.model.event;

import christmas.constant.DateConstant;
import christmas.constant.EventConstant;
import christmas.model.Visit;

public class SpecialDiscount extends Discount implements DateConstant, EventConstant {

    public SpecialDiscount(Visit visit) {
        this.amount = applyDiscount(visit);
    }

    private int applyDiscount(Visit visit) {

        int date = visit.getDate();

        if (SPECIAL_DAYS.contains(date)) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }

        return DISCOUNT_INITIAL_AMOUNT;
    }
}
