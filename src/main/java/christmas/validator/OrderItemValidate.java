package christmas.validator;

import christmas.model.Category;
import christmas.model.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class OrderItemValidate {

    //    private String INPUT_ORDER_ITEM_REGEX = "([가-힣]+)-([0-9]+)";
    private static Pattern pattern = Pattern.compile("([가-힣]+)-([0-9]+)");

    public static void validate(String inputOrder) {
        inputOrder = inputOrder.replaceAll(" ", "");
        List<String> inputOrderItem = List.of(inputOrder.split(","));

        validateOrderFormat(inputOrderItem);
        validateOrderItemName(inputOrderItem);
        validateOnlyBeverageOrdered(inputOrderItem);
        validateMenuCount(inputOrderItem);
    }

    private static void validateOrderFormat(List<String> inputOrderItem) {

        for (String item : inputOrderItem) {
            if (!pattern.matcher(item).matches()) {
                throw new IllegalArgumentException("[ERROR] 주문 양식이 올바르지 않습니다. (주문메뉴-수량) ");
            }
        }
    }

    private static void validateOrderItemName(List<String> inputOrderItem) {
        inputOrderItem.stream()
                .map(item -> item.split("-")[0])
                .filter(menuName -> !hasItemName(menuName))
                .findAny()
                .ifPresent(menuName -> {
                    throw new IllegalArgumentException("[ERROR] 해당 메뉴는 존재하지 않습니다: ");
                });
    }

    private static void validateOnlyBeverageOrdered(List<String> inputOrderItem) {
        long beverageCount = inputOrderItem.stream()
                .map(item -> item.split("-")[0])
                .map(Menu::valueOf)
                .filter(menu -> menu.getCategory() == Category.BEVERAGE)
                .count();
        if (Category.BEVERAGE.getCount() > 0 && Category.getTotalCount() == beverageCount) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문할 수 없습니다!");
        }
    }

    private static void validateMenuCount(List<String> inputOrderItem) {
        int totalItemCount = inputOrderItem.stream()
                .mapToInt(item -> Integer.parseInt(item.split("-")[1]))
                .sum();

        if (totalItemCount>20) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한번에 20개 까지만 주문 가능합니다.");
        }
    }

    private static boolean hasItemName(String menuName) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.getName().equals(menuName));
    }
}
