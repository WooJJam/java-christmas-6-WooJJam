package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Order;
import christmas.service.OrderService;

public class OrderController {

    private final OrderService orderService = new OrderService();

    public void inputOrderMenu() {
        try {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String userInput = Console.readLine();
            System.out.println("<주문 메뉴>");
            Order order = this.orderService.createOrderMenu(userInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputOrderMenu();
        }

    }

}
