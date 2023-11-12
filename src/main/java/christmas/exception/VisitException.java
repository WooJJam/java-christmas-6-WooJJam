package christmas.exception;

import christmas.constant.ExceptionMessage;
import christmas.exception.message.VisitExceptionMessage;

public class VisitException extends IllegalArgumentException implements ExceptionMessage {
    public VisitException(VisitExceptionMessage visitExceptionMessage) {
        super(PREFIX_ERROR_MESSAGE+visitExceptionMessage.getMessage());
    }
}
