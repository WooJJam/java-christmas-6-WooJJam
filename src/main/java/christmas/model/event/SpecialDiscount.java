package christmas.model.event;

import christmas.constant.DateConstant;
import christmas.constant.EventConstant;
import christmas.model.Order;
import christmas.model.Visit;

public class SpecialDiscount extends Discount implements DateConstant, EventConstant {

    public SpecialDiscount(Visit visit, Order order) {
        this.amount = applyDiscount(visit, order);
    }

    private int applyDiscount(Visit visit, Order order) {

        int date = visit.getDate();

        if (SPECIAL_DAYS.contains(date) && order.getAmount() >= DISCOUNT_EVENT_THRESHOLD) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }

        return DISCOUNT_INITIAL_AMOUNT;
    }
}
