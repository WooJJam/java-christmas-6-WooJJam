package christmas.model.event;

import christmas.model.*;

import java.util.Arrays;
import java.util.List;

public class WeekOfDayDiscount extends Discount{

    public WeekOfDayDiscount(Visit visit, Order order) {
        this.amount = 0;
        applyDiscount(visit, order);
    }

    public void applyDiscount(Visit visit, Order order) {
        if (visit.getDay().equals(Week.WEEKDAY)) {
            weekdayDiscountPolicy(order);
        }
    }

    private void weekdayDiscountPolicy(Order order) {
        List<OrderItem> orderItem = order.getOrderItems();

        this.amount = orderItem.stream()
                .mapToInt(item -> {
                    String itemName = item.getMenu();
                    return Arrays.stream(Menu.values())
                            .filter(menu -> itemName.equals(menu.getName()) && menu.getCategory().equals(Category.DESSERT))
                            .mapToInt(menu -> 2023 * item.getQuantity())
                            .sum();
                })
                .sum();
    }
}
