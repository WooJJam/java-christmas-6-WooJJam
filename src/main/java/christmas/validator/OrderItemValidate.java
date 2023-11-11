package christmas.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderItemValidate {

    public static void validate(String userInput) {
        validateOrderFormat(userInput);
    }

    private static void validateOrderFormat(String userInput) {
        userInput = userInput.replaceAll(" ", "");
        List<String> userInputs = List.of(userInput.split(","));

        String INPUT_ORDER_ITEM_REGEX = "([가-힣]+)-([0-9]+)";
        Pattern pattern = Pattern.compile(INPUT_ORDER_ITEM_REGEX);
        for (String input : userInputs) {
            if (!pattern.matcher(input).matches()) {
                throw new IllegalArgumentException("[ERROR] 주문 양식이 올바르지 않습니다. (주문메뉴-수량) ");
            }
        }
    }
}
