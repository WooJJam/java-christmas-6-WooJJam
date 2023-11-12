package christmas.exception.message;

public enum OrderExceptionMessage {
    INVALID_ORDER_FORMAT("주문 양식이 올바르지 않습니다. (주문메뉴-수량) "),
    INVALID_ITEM_NAME("해당 메뉴는 존재하지 않습니다."),
    ONLY_BEVERAGE_ORDERED("음료만 주문할 수 없습니다!"),
    INVALID_MENU_COUNT("메뉴는 한번에 20개 까지만 주문 가능합니다.");

    private final String message;
    OrderExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
