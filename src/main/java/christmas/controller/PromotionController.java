package christmas.controller;

import christmas.model.Order;
import christmas.model.Visit;

public class PromotionController {
    private final OrderController orderController;
    private final DateController dateController;
    private final EventController eventController;

    public PromotionController(OrderController orderController, DateController dateController, EventController eventController) {
        this.orderController = orderController;
        this.dateController = dateController;
        this.eventController = eventController;
    }

    public void run() {
        Visit visit = setVisitDate();
        Order order = inputOrderMenu();
        applyDiscountPolicy(visit,order);

    }

    public Visit setVisitDate() {
        return this.dateController.inputVisitDate();

    }

    private Order inputOrderMenu() {
        return orderController.inputOrderMenu();
    }

    public void applyDiscountPolicy(Visit visit, Order order) {
        this.eventController.applyDiscountPolicy(visit,order);
    }
}
