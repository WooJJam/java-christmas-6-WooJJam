package christmas.model.event;

import christmas.model.Order;
import christmas.model.Visit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.internal.matchers.Or;

import static org.junit.jupiter.api.Assertions.*;

class SpecialDiscountTest {

    @ParameterizedTest
    @CsvSource({
            "3, '티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1', 1000",
            "15, '티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1', 0",
            "18, '티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1', 0",
            "25, '티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1', 1000"
    })
    void 날짜에_별표가_있으면_특별_이벤트_적용(String visitDay, String orderItem, int expectedAmount) {
        Visit visit = new Visit(visitDay);
        Order order = new Order(orderItem);
        SpecialDiscount specialDiscount = new SpecialDiscount(visit, order);
        assertEquals(specialDiscount.getAmount(), expectedAmount);
    }
}