package christmas.view.message;

public enum OutputMessage {

    ORDER_MENU("<주문 메뉴>"),
    MENU_LIST("%s : %d개\n"),
    TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    FORMAT_PRICE_WITH_COMMA("%,d원\n"),
    BENEFITS_HISTORY("<혜택 내역>"),
    CHRISTMAS_DISCOUNT_EVENT("크리스마스 디데이 할인: -%,d원\n");

    private final String message;
    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
