package christmas.model.event;

import christmas.model.Order;
import christmas.model.Visit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.internal.matchers.Or;

import static org.junit.jupiter.api.Assertions.*;

class GiftDiscountTest {

    @ParameterizedTest
    @CsvSource({
            "'티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1', 25000",
            "'양송이수프-2,아이스크림-2,제로콜라-1', 0",
            "'바비큐립-1,아이스크림-1,제로콜라-1', 0",
            "'티본스테이크-2, 아이스크림-2', 25000"
    })
    @DisplayName("증정 이벤트를 적용한다.")
    void 증정_이벤트_적용(String orderItems, int expectedAmount) {
        Order order = new Order(orderItems);
        GiftDiscount giftDiscount = new GiftDiscount(order);
        assertEquals(giftDiscount.getAmount(), expectedAmount);
    }
}