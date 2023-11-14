package christmas.util;

import christmas.constant.OrderConstant;

import java.util.List;
import java.util.stream.Collectors;

public class OrderItemParserUtil implements OrderConstant {
    public static List<String> parseOrderItems(String inputOrder) {

        String formattedOrder = inputOrder.replaceAll(INPUT_ORDER_REPLACE_BLANK_REGEX, INPUT_ORDER_REPLACE_REPLACEMENT);

        return List.of(formattedOrder.split(INPUT_ORDER_SPLIT_DELIMITER_REGEX));
    }

    public static String extractMenuName(String orderItem) {

        return orderItem.split(INPUT_ORDER_SPLIT_HYPHEN_REGEX)[ZERO_INDEX];
    }

    public static int extractQuantity(String orderItem) {

        return Integer.parseInt(orderItem.split(INPUT_ORDER_SPLIT_HYPHEN_REGEX)[FIRST_INDEX]);
    }

    public static List<Integer> extractQuantities(List<String> inputOrderItems) {

        return inputOrderItems.stream()
                .map(OrderItemParserUtil::extractQuantity)
                .collect(Collectors.toList());
    }
}
