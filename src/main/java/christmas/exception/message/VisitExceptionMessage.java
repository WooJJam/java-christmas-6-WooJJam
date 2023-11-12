package christmas.exception.message;

public enum VisitExceptionMessage {
    NOT_INTEGER_VALUE("날짜는 정수만 입력 가능 합니다."),
    INVALID_DATE_RANGE("날짜는 1에서 31 사이어야 합니다. 다시 입력해주세요.");

    private final String message;

    VisitExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
