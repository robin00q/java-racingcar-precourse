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

    @ParameterizedTest(name = "자동차의 이름과 위치를 반환한다.")
    @MethodSource("car_to_string_parameter")
    void car_to_string(Car car, String expected) {
        // given: none

        // when, then
        assertThat(car.toString()).isEqualTo(expected);
    }

    static Stream<Arguments> car_to_string_parameter() {
        return Stream.of(
                Arguments.of(new Car("test0", 0), "test0 : "),
                Arguments.of(new Car("test1", 1), "test1 : -"),
                Arguments.of(new Car("test5", 5), "test5 : -----"));
    }

}
