package christmas.model;

import christmas.validator.OrderItemValidate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
    private final List<OrderItem> orderItems;

    public Order(String inputMenu) {
        this.orderItems = new ArrayList<>();
        addOrder(inputMenu);
    }

    public void addOrder(String inputMenu) {
        OrderItemValidate.validate(inputMenu);

        String INPUT_ORDER_ITEM_REGEX = "([가-힣]+)-([0-9]+)";
        Pattern pattern = Pattern.compile(INPUT_ORDER_ITEM_REGEX);

        Matcher matcher = pattern.matcher(inputMenu);

        while (matcher.find()) {
            String menu = matcher.group(1);
            int quantity = Integer.parseInt(matcher.group(2));
            orderItems.add(new OrderItem(menu,quantity));
        }
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
