package christmas.service;

import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.message.OutputMessage;


public class OrderService {

    public Order createOrderMenu() {
        try {
            String inputOrderMenu = InputView.inputOrderMenu();
            OutputView.printOrderMenu();
            return new Order(inputOrderMenu);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return createOrderMenu();
        }
    }
}
