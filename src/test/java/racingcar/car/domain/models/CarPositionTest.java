package racingcar.car.domain.models;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.domain.errors.CarErrors;

class CarPositionTest {

    @ParameterizedTest(name = "정상적으로 위치 객체를 생성한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void create_car_position(int validPosition) {
        // given: none

        // when, then
        assertThatCode(() -> new CarPosition(validPosition))
                .doesNotThrowAnyException();
    }

    @DisplayName("위치 객체를 생성한다. 0 미만의 위치는 가질 수 없다.")
    @Test
    void create_car_position_less_than_0() {
        // given
        int invalidPosition = -1;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarPosition(invalidPosition))
                .withMessageStartingWith(CarErrors.CAR_POSITION_LESS_THAN_ZERO_ERROR);
    }
}
