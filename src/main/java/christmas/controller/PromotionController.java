package christmas.controller;

import christmas.model.Visit;

public class PromotionController {
    private final OrderController orderController;
    private final DateController dateController;
    public static final String INPUT_DATE_REGEX = "^[0-9]*$";

    public PromotionController(OrderController orderController, DateController dateController) {
        this.orderController = orderController;
        this.dateController = dateController;
    }

    public void run() {
        Visit visit = setVisitDate();
        inputOrderMenu();
    }

    public Visit setVisitDate() {
        return this.dateController.inputVisitDate();

    }

    private void inputOrderMenu() {
        orderController.inputOrderMenu();
    }
}
