package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.message.InputViewMessage;

public class InputView {
    public static String readDate() {
        System.out.println(InputViewMessage.DATE.getMessage());
        return Console.readLine();
    }

    public static String inputOrderMenu() {
        System.out.println(InputViewMessage.ORDER_MENU.getMessage());
        return Console.readLine();
    }
}
