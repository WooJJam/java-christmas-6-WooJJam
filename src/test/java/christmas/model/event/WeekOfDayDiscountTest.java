package christmas.model.event;

import christmas.model.Order;
import christmas.model.Visit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class WeekOfDayDiscountTest {

    @ParameterizedTest
    @CsvSource({
            "3, '티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1', 4046",
            "15, '양송이수프-2,아이스크림-2,제로콜라-1', 0",
            "18, '바비큐립-1,아이스크림-1,제로콜라-1', 2023"
    })
    @DisplayName("평일 할인 이벤트를 적용한다.")
    void 평일_할인_이벤트_적용(String visitDay, String orderItems, int expectedAmount) {
        Visit visit = new Visit(visitDay);
        Order order = new Order(orderItems);

        WeekOfDayDiscount weekOfDayDiscount = new WeekOfDayDiscount(visit,order);

        assertEquals(expectedAmount, weekOfDayDiscount.getAmount());
    }

    @ParameterizedTest
    @CsvSource({
            "3, '티본스테이크-1,바비큐립-1,제로콜라-1', 0",
            "15, '양송이수프-2,티본스테이크-2,아이스크림-2,제로콜라-1', 4046",
            "23, '바비큐립-1,해산물파스타-2,제로콜라-3', 6069"
    })
    @DisplayName("주말 할인 이벤트를 적용한다.")
    void 주말_할인_이벤트_적용(String visitDay, String orderItems, int expectedAmount) {
        Visit visit = new Visit(visitDay);
        Order order = new Order(orderItems);

        WeekOfDayDiscount weekOfDayDiscount = new WeekOfDayDiscount(visit,order);

        assertEquals(expectedAmount, weekOfDayDiscount.getAmount());
    }

}