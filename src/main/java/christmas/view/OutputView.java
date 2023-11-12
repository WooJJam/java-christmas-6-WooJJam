package christmas.view;

import christmas.model.Order;
import christmas.model.OrderItem;
import christmas.view.message.OutputMessage;

public class OutputView {

    public static void printOrderMenu() {
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
    }
    public static void printMenuList(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            System.out.printf(OutputMessage.MENU_LIST.getMessage(), orderItem.getMenu(), orderItem.getQuantity());
            System.out.println();
        }
    }
}
