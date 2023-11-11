package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

class OrderTest {

    @Test
    @DisplayName("주문한 메뉴들의 갯수가 20개를 초과하는 경우 예외가 발생한다.")
    void 주문한_메뉴들이_20개_초과일시_주문이_불가능() {
        Assertions.assertThatThrownBy(() -> new Order("제로콜라-10,초코케이크-12,아이스크림-10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test()
    @DisplayName("주문한 메뉴가 없는 경우 예외가 발생한다.")
    void 주문한_메뉴가_존재하는지_검증() {
        Assertions.assertThatThrownBy(() -> new Order("빼뺴로-3, 제로콜라-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test()
    @DisplayName("음료만 주문하는 경우 예외가 발생한다.")
    void 음료만_주문하는_경우_주문이_불가능() {
        Assertions.assertThatThrownBy(() -> new Order("제로콜라-1, 레드와인-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test()
    @DisplayName("주문 형식이 올바르지 않는 경우 예외가 발생한다.")
    void 주문_형식_유효성_검사() {
        Assertions.assertThatThrownBy(() -> new Order("초코케이크3, 제로콜라-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}