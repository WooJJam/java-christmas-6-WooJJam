package christmas.service;

import christmas.model.Order;
import christmas.view.InputView;


public class OrderService {

    public Order createOrderMenu() {
        try {
            String inputOrderMenu = InputView.inputOrderMenu();
            System.out.println("<주문 메뉴>");
            return new Order(inputOrderMenu);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return createOrderMenu();
        }
    }
}
