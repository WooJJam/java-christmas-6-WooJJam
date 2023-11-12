package christmas.controller;

import christmas.model.Order;
import christmas.service.OrderService;

public class OrderController {

    private final OrderService orderService = new OrderService();

    public Order inputOrderMenu() {
        return this.orderService.createOrderMenu();
    }

}
