package christmas.model.event;

import christmas.model.Visit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SpecialDiscountTest {

    @ParameterizedTest
    @CsvSource({
            "3,1000",
            "15, 0",
            "18, 0",
            "25, 1000"
    })
    void 날짜에_별표가_있으면_특별_이벤트_적용(String visitDay, int expectedAmount) {
        Visit visit = new Visit(visitDay);
        SpecialDiscount specialDiscount = new SpecialDiscount(visit);
        assertEquals(specialDiscount.getAmount(), expectedAmount);
    }
}