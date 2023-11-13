package christmas.model.event;

import christmas.model.*;

import java.util.Arrays;
import java.util.List;

public class WeekOfDayDiscount extends Discount{

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
        List<OrderItem> orderItem = order.getOrderItems();

        return orderItem.stream()
                .mapToInt(item -> {
                    String itemName = item.getMenu();
                    return Arrays.stream(Menu.values())
                            .filter(menu -> itemName.equals(menu.getName()) && menu.getCategory().equals(category))
                            .mapToInt(menu -> 2023 * item.getQuantity())
                            .sum();
                })
                .sum();
    }
}
