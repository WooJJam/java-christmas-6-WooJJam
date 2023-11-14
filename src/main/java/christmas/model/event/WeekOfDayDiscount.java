package christmas.model.event;

import christmas.model.*;

import java.util.Arrays;
import java.util.List;

public class WeekOfDayDiscount extends Discount {

    public WeekOfDayDiscount(Visit visit, Order order) {
        this.amount = applyDiscount(visit, order);
    }

    public int applyDiscount(Visit visit, Order order) {

        if (visit.getDay().equals(Week.WEEKDAY)) {
            return discountPolicy(order, Category.DESSERT);
        }

        return discountPolicy(order, Category.MAIN_COURSE);
    }

    private int discountPolicy(Order order, Category category) {

        List<OrderItem> orderItems = order.getOrderItems();

        if (order.getAmount() >= DISCOUNT_EVENT_THRESHOLD) {
            return orderItems.stream()
                    .mapToInt(item -> calculateDiscount(item, category))
                    .sum();
        }

        return DISCOUNT_INITIAL_AMOUNT;
    }

    private int calculateDiscount(OrderItem item, Category category) {

        String itemName = item.getMenu();

        return Arrays.stream(Menu.values())
                .filter(menu -> itemName.equals(menu.getName()) && menu.getCategory().equals(category))
                .mapToInt(menu -> WEEK_OF_DAY_DISCOUNT_INCREASE_AMOUNT * item.getQuantity())
                .sum();
    }
}
