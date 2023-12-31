package christmas;

import christmas.controller.DateController;
import christmas.controller.EventController;
import christmas.controller.OrderController;
import christmas.controller.PromotionController;

public class Application {
    public static void main(String[] args) {
        PromotionController promotionController =
                new PromotionController(new OrderController(), new DateController(), new EventController());

        promotionController.run();
    }
}
