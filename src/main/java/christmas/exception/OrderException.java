package christmas.exception;

import christmas.constant.ExceptionMessage;
import christmas.exception.message.OrderExceptionMessage;

public class OrderException extends IllegalArgumentException implements ExceptionMessage {
    public OrderException(OrderExceptionMessage orderExceptionMessage) {
        super(PREFIX_ERROR_MESSAGE+orderExceptionMessage.getMessage());
    }
}
