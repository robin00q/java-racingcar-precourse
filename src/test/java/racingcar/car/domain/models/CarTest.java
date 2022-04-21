package racingcar.car.domain.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {

    private static final String carName = "sjlee";

    @DisplayName("정상적으로 자동차 객체를 생성한다.")
    @Test
    void create_car() {
        // given: none

        // when, then
        assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "자동차 한대를 앞으로 전진한다.")
    @MethodSource("move_car_parameter")
    void move_car(Car beforeMoved, CarMovePolicy policy, Car afterMoved) {
        // given: none

        // when, then
        assertThat(beforeMoved.moveForward(policy)).isEqualTo(afterMoved);
    }

    static Stream<Arguments> move_car_parameter() {
        return Stream.of(
                Arguments.of(new Car(carName, 0), CarMovePolicy.MOVE, new Car(carName, 1)),
                Arguments.of(new Car(carName, 1), CarMovePolicy.MOVE, new Car(carName, 2)),
                Arguments.of(new Car(carName, 2), CarMovePolicy.STOP, new Car(carName, 2)),
                Arguments.of(new Car(carName, 3), CarMovePolicy.STOP, new Car(carName, 3)));
    }
}
