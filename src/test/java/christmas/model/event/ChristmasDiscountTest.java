package christmas.model.event;

import christmas.model.Order;
import christmas.model.Visit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasDiscountTest {

    @ParameterizedTest
    @DisplayName("크리스마스 디데이 할인 이벤트를 적용한다.")
    @CsvSource({
            "25, '크리스마스파스타-2,바비큐립-1,초코케이크-1,레드와인-1', 3400",
            "26, '티본스테이크-1, 초코케이크-2,제로콜라-1', 0",
            "1, '양송이수프-2, 해산물파스타-1,아이스크림-2,제로콜라-1', 1000",
            "10, '티본스테이크-2,바비큐립-1,초코케이크-1,샴페인-1', 1900"
    })
    void 크리스마스_디데이_할인_이벤트_적용(String day, String orderItems, int expectedAmount) {
        Visit visit = new Visit(day);
        Order order = new Order(orderItems);
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(visit,order);
        assertEquals(christmasDiscount.getAmount(), expectedAmount);
    }
}