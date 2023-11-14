package christmas.model.event;

import christmas.constant.EventConstant;
import christmas.model.Menu;
import christmas.model.Order;

public class GiftDiscount extends Discount implements EventConstant {

    public GiftDiscount(Order order) {
        this.amount = applyDiscount(order);
    }

    private int applyDiscount(Order order) {

        int totalOrderAmount = order.getAmount();

        if (totalOrderAmount >= GIFT_EVENT_THRESHOLD_AMOUNT) {
            return Menu.CHAMPAGNE.getPrice();
        }

        return DISCOUNT_INITIAL_AMOUNT;
    }
}
