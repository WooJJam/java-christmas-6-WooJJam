package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Order;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.message.InputViewMessage;

public class OrderController {

    private final OrderService orderService = new OrderService();

    public void inputOrderMenu() {
        try {
            String inputOrderMenu = InputView.inputOrderMenu();
            System.out.println("<주문 메뉴>");
            Order order = this.orderService.createOrderMenu(inputOrderMenu);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputOrderMenu();
        }

    }

}
