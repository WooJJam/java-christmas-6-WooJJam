package christmas.model;

import christmas.model.date.Visit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class VisitTest {
    @Test
    @DisplayName("방문 일자가 범위를 벗어난 경우 예외가 발생한다.")
    void 방문일자_범위_검증() {
        Assertions.assertThatThrownBy(() -> new Visit("32")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("방문 일자가 숫자가 아닌 경우 예외를 발생한다.")
    void 방문일자_숫자_검증() {
        Assertions.assertThatThrownBy(() -> new Visit("test")).isInstanceOf(IllegalArgumentException.class);
    }
}