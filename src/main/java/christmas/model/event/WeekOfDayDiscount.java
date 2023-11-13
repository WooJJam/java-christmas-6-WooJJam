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
            discountPolicy(order, Category.DESSERT);
        }
        if (visit.getDay().equals(Week.WEEKEND)) {
            discountPolicy(order, Category.MAIN_COURSE);
        }
    }

    private void discountPolicy(Order order, Category category) {
        List<OrderItem> orderItem = order.getOrderItems();

        this.amount = orderItem.stream()
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
