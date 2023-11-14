package christmas.model.event;

import christmas.constant.EventConstant;
import christmas.model.Visit;

public class ChristmasDiscount extends Discount implements EventConstant {

    public ChristmasDiscount(Visit visit) {

        this.amount = CHRISTMAS_DISCOUNT_AMOUNT;
        applyDiscount(visit);
    }

    public void applyDiscount(Visit visit) {

        if (visit.getDate() > CHRISTMAS_DISCOUNT_RANGE) {
            this.amount = DISCOUNT_INITIAL_AMOUNT;
            return;
        }

        this.amount += (visit.getDate() - CHRISTMAS_DISCOUNT_CALCULATE_ONE) * CHRISTMAS_DISCOUNTS_INCREASE_AMOUNT;
    }

}
