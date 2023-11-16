package christmas.view.message;

public enum OutputMessage {

    ORDER_MENU("\n<주문 메뉴>"),
    MENU_LIST("%s : %d개\n"),
    TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    FORMAT_PRICE_WITH_COMMA("%,d원\n"),
    GIFT_MENU_NAME("<증정 메뉴>"),
    GIFT_MENU("%s %d개\n"),
    NON_EXIST("없음\n"),
    BENEFITS_HISTORY("<혜택 내역>"),
    CHRISTMAS_DISCOUNT_EVENT("크리스마스 디데이 할인: -%,d원\n"),
    WEEK_OF_DAY_DISCOUNT_EVENT("%s 할인: -%,d원\n"),
    SPECIAL_DISCOUNT_EVENT("특별 할인: -%,d원\n"),
    GIFT_DISCOUNT_EVENT("증정 이벤트: -%,d원\n"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    TOTAL_DISCOUNT_AMOUNT("-%,d원\n"),
    NONE_TOTAL_DISCOUNT_AMOUNT("%,d원\n"),

    ESTIMATED_AMOUNT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    FINAL_AMOUNT("%,d원\n"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>"),
    EVENT_BADGE("%s\n");

    private final String message;
    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
