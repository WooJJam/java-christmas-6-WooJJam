package christmas.validator;

import christmas.constant.OrderConstant;
import christmas.exception.OrderException;
import christmas.exception.message.OrderExceptionMessage;
import christmas.model.Category;
import christmas.model.Menu;
import christmas.util.OrderItemParserUtil;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class OrderItemValidate implements OrderConstant{

    private static final Pattern pattern = Pattern.compile(INPUT_ORDER_ITEM_REGEX);

    public static void validate(String inputOrder) {
        List<String> inputOrderItem = OrderItemParserUtil.parseOrderItems(inputOrder);

        validateOrderFormat(inputOrderItem);
        validateOrderItemName(inputOrderItem);
        validateOnlyBeverageOrdered(inputOrderItem);
        validateMenuCount(inputOrderItem);
    }

    private static void validateOrderFormat(List<String> inputOrderItem) {

        for (String item : inputOrderItem) {
            if (!pattern.matcher(item).matches()) {
                throw new OrderException(OrderExceptionMessage.INVALID_ORDER_FORMAT);
            }
        }
    }

    private static void validateOrderItemName(List<String> inputOrderItem) {
        inputOrderItem.stream()
                .map(OrderItemParserUtil::extractMenuName)
                .filter(menuName -> !hasItemName(menuName))
                .findAny()
                .ifPresent(menuName -> {
                    throw new OrderException(OrderExceptionMessage.INVALID_ITEM_NAME);
                });
    }

    private static void validateOnlyBeverageOrdered(List<String> inputOrderItem) {
        for (String item : inputOrderItem) {
            item = OrderItemParserUtil.extractMenuName(item);
            hasOtherItemOrdered(item);
        }

        if (Category.BEVERAGE.getCount() >0 && Category.getTotalCount() == Category.BEVERAGE.getCount()) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문할 수 없습니다!");
        }
    }

    private static void hasOtherItemOrdered(String item) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(item)) {
                menu.getCategory().addCount();
            }
        }
    }

    private static void validateMenuCount(List<String> inputOrderItem) {
        List<Integer> quantities = OrderItemParserUtil.extractQuantities(inputOrderItem);
        int totalItemCount = quantities.stream().mapToInt(Integer::intValue).sum();

        if (totalItemCount>20) {
            throw new OrderException(OrderExceptionMessage.INVALID_MENU_COUNT);
        }
    }

    private static boolean hasItemName(String menuName) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.getName().equals(menuName));
    }
}
