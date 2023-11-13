package christmas.model.event;

import christmas.model.Menu;
import christmas.model.Order;

public class GiftDiscount extends Discount {

    public GiftDiscount(Order order) {
        this.amount = applyDiscount(order);
    }

    private int applyDiscount(Order order) {
        int totalOrderAmount = order.getAmount();

        if (totalOrderAmount >= 120000){
            return Menu.CHAMPAGNE.getPrice();
        }
        return 0;
    }
}
