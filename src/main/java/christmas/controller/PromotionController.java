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
        Visit visit = reservationVisitDate();
        Order order = inputOrderMenu();
        int benefit = applyEventPolicy(visit, order);
        applyBadge(benefit);
    }

    private Visit reservationVisitDate() {
        return this.dateController.inputVisitDate();
    }

    private Order inputOrderMenu() {
        return orderController.inputOrderMenu();
    }

    private int applyEventPolicy(Visit visit, Order order) {
        return this.eventController.applyEventPolicy(visit, order);
    }

    private void applyBadge(int benefit) {
        this.eventController.processEventBadge(benefit);
    }
}
