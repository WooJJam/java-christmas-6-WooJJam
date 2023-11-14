package christmas.exception.message;

public enum OrderExceptionMessage {

    DUPLICATE_ORDER_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ORDER_FORMAT("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ITEM_NAME("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ONLY_BEVERAGE_ORDERED("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MENU_COUNT("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    OrderExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
