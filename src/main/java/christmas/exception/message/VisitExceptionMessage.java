package christmas.exception.message;

public enum VisitExceptionMessage {
    NOT_INTEGER_VALUE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_DATE_RANGE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    VisitExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
