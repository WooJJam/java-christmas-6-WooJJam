package christmas.controller;

import christmas.model.Order;
import christmas.model.Visit;

public class PromotionController {
    private final OrderController orderController;
    private final DateController dateController;

    public PromotionController(OrderController orderController, DateController dateController) {
        this.orderController = orderController;
        this.dateController = dateController;
    }

    public void run() {
        Visit visit = setVisitDate();
        Order order = inputOrderMenu();
    }

    public Visit setVisitDate() {
        return this.dateController.inputVisitDate();

    }

    private Order inputOrderMenu() {
        return orderController.inputOrderMenu();
    }
}
