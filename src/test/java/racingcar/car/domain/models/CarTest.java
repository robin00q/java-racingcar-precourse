package racingcar.car.domain.models;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("정상적으로 자동차 객체를 생성한다.")
    @Test
    void create_car() {
        // given
        String name = "sjlee"; // 5글자

        // when, then
        assertThatCode(() -> new Car(name))
                .doesNotThrowAnyException();
    }

}
