package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.OrderItem;
import christmas.model.Visit;
import christmas.service.PromotionService;
import christmas.view.InputView;

public class PromotionController {
    private final PromotionService promotionService;
    private final OrderController orderController;
    public static final String INPUT_DATE_REGEX = "^[0-9]*$";

    public PromotionController(OrderController orderController, PromotionService promotionService) {
        this.orderController = orderController;
        this.promotionService = promotionService;
    }

    public void run() {
        Visit visit = inputVisitDate();
        inputOrderMenu();
    }

    public Visit inputVisitDate() {
        Visit visit = null;

        try {
            String inputDate = InputView.readDate();
            visit = this.promotionService.setVisitDate(inputDate);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputVisitDate();
        }
        return visit;
    }

    private void inputOrderMenu() {
        orderController.inputOrderMenu();
    }
}
