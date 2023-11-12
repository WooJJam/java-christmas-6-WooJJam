package christmas.controller;

import christmas.model.Order;
import christmas.service.OrderService;
import christmas.view.OutputView;

public class OrderController {

    private final OrderService orderService = new OrderService();

    public Order inputOrderMenu() {
        Order order = this.orderService.createOrderMenu();
        OutputView.printMenuList(order);
        return order;
    }
}
