package christmas.model.event;

import christmas.constant.EventConstant;
import christmas.model.order.Order;
import christmas.model.date.Visit;

public class ChristmasDiscount extends Discount implements EventConstant {

    public ChristmasDiscount(Visit visit, Order order) {

        this.amount = applyDiscount(visit, order);
    }

    public int applyDiscount(Visit visit, Order order) {

        if (visit.getDate() > CHRISTMAS_DISCOUNT_RANGE || order.getAmount() < DISCOUNT_EVENT_THRESHOLD) {
            return DISCOUNT_INITIAL_AMOUNT;
        }

        return CHRISTMAS_DISCOUNT_AMOUNT + (visit.getDate() - CHRISTMAS_DISCOUNT_CALCULATE_ONE) * CHRISTMAS_DISCOUNTS_INCREASE_AMOUNT;
    }

}
