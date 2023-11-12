package christmas.model.event;

import christmas.model.Visit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasDiscountTest {

    @ParameterizedTest
    @CsvSource({
            "25, 3400",
            "26, 0",
            "1, 1000",
            "10, 1900"
    })
    void 크리스마스_디데이_할인_이벤트_적용(String day, int expectedAmount) {
        Visit visit = new Visit(day);
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(visit);
        assertEquals(christmasDiscount.getAmount(), expectedAmount);
    }
}