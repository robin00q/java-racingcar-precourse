package racingcar.car.domain.models;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @DisplayName("승리자들 객체를 생성한다.")
    @Test
    void create_winners() {
        // given
        String name = "sjlee";

        // when, then
        assertThatCode(() -> new Winners(Collections.singletonList(new Car(name))))
                .doesNotThrowAnyException();
    }

    @DisplayName("승리자들 객체에는 항상 승리자가 한명이상 존재해야한다.")
    @Test
    void create_winners_invalid() {
        // given: none

        // when
        assertThatIllegalStateException()
                .isThrownBy(() -> new Winners(null))
                .withMessage("[ERROR] 최소 한명의 승리자가 존재해야합니다.");
    }
}