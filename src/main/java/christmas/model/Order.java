package christmas.model;

import christmas.constant.OrderConstant;
import christmas.validator.OrderItemValidate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order implements OrderConstant {
    private final List<OrderItem> orderItems;
    public int amount;

    public Order(String inputMenu) {
        this.orderItems = new ArrayList<>();
        addOrder(inputMenu);
        calculateOrderAmount();
    }

    public void addOrder(String inputMenu) {
        OrderItemValidate.validate(inputMenu);

        Pattern pattern = Pattern.compile(INPUT_ORDER_ITEM_REGEX);

        Matcher matcher = pattern.matcher(inputMenu);

        while (matcher.find()) {
            String menu = matcher.group(MATCHER_GROUP_FIRST);
            int quantity = Integer.parseInt(matcher.group(MATCHER_GROUP_SECOND));
            orderItems.add(new OrderItem(menu, quantity));
        }
    }

    public void calculateOrderAmount() {
        this.amount += orderItems.stream().mapToInt(item -> {
                    Menu menu = Arrays.stream(Menu.values())
                            .filter(m -> m.getName().equals(item.getMenu()))
                            .findFirst()
                            .orElseThrow();
                    return menu.getPrice() * item.getQuantity();
                })
                .sum();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public int getAmount() {
        return amount;
    }
}
