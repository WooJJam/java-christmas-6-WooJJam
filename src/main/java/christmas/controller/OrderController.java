package christmas.controller;

import christmas.model.order.Order;
import christmas.service.OrderService;
import christmas.view.OutputView;

public class OrderController {

    private final OrderService orderService = new OrderService();

    public Order processOrder() {

        Order order = this.orderService.createOrderMenu();
        OutputView.printOrderSummary(order);

        return order;
    }
}
