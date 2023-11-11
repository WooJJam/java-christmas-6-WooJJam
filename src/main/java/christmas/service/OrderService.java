package christmas.service;

import christmas.model.Order;
import christmas.validator.OrderItemValidate;


public class OrderService {

    public Order createOrderMenu(String inputMenu) {
        return new Order(inputMenu);
    }
}
