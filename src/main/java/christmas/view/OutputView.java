package christmas.view;

import christmas.model.Order;
import christmas.model.OrderItem;
import christmas.model.event.ChristmasDiscount;
import christmas.view.message.OutputMessage;

public class OutputView {

    public static void printOrderMenu() {
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
    }
    public static void printMenuList(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            System.out.printf(OutputMessage.MENU_LIST.getMessage(), orderItem.getMenu(), orderItem.getQuantity());
        }
        System.out.println();

    }

    public static void printTotalAmountBeforeDiscount(Order order) {
        System.out.println(OutputMessage.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage());
        System.out.printf(OutputMessage.FORMAT_PRICE_WITH_COMMA.getMessage(), order.getAmount());
        System.out.println();
    }

    public static void printBenefitsHistory(ChristmasDiscount christmasDiscount) {
        System.out.println(OutputMessage.BENEFITS_HISTORY.getMessage());
        System.out.printf(OutputMessage.CHRISTMAS_DISCOUNT_EVENT.getMessage(), christmasDiscount.getAmount());
        System.out.println();
    }
}
