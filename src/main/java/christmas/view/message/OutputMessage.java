package christmas.view.message;

public enum OutputMessage {

    ORDER_MENU("<주문 메뉴>"),
    MENU_LIST("%s : %d개");

    private final String message;
    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
