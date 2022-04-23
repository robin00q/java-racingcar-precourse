package racingcar.car.domain.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.car.domain.errors.CarErrors;
import racingcar.car.domain.external.CarMovePolicyStrategy;
import racingcar.util.StringUtils;

class CarsTest {

    private static final String firstName = "lee";
    private static final String secondName = "suk";
    private static final String thirdName = "june";

    private static final Cars initialCars = Cars.initCarsByName(Arrays.asList(firstName, secondName, thirdName));

    @DisplayName("자동차들 객체를 생성한다.")
    @Test
    void create_cars() {
        // given

        // when, then
        assertThatCode(() -> Cars.initCarsByName(Arrays.asList(firstName, secondName, thirdName)))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "자동차들 객체를 비정상적으로 생성한다.")
    @MethodSource("create_cars_invalid_parameter")
    void create_cars_invalid(List<String> cars) {
        // given: none

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.initCarsByName(cars))
                .withMessage(CarErrors.CARS_EMPTY_ERROR);
    }

    static Stream<List<String>> create_cars_invalid_parameter() {
        return Stream.of(null, Collections.emptyList());
    }

    @ParameterizedTest(name = "전략을 통해, 자동차 여러대들을 움직인다.")
    @MethodSource("move_cars_forward_parameter")
    void move_cars_forward(Cars before, CarMovePolicyStrategy strategy, Cars expected) {
        // given: none

        // when, then
        assertThat(before.moveForward(strategy)).isEqualTo(expected);
    }

    static Stream<Arguments> move_cars_forward_parameter() {
        return Stream.of(
                Arguments.of(
                        initialCars,
                        (CarMovePolicyStrategy) () -> CarMovePolicy.MOVE,
                        new Cars(Arrays.asList(new Car(firstName, 1), new Car(secondName, 1), new Car(thirdName, 1)))),
                Arguments.of(
                        initialCars,
                        (CarMovePolicyStrategy) () -> CarMovePolicy.STOP,
                        initialCars));
    }

    @ParameterizedTest(name = "자동차들의 이름과 위치를 반환한다.")
    @MethodSource("cars_to_string_parameter")
    void cars_to_string(Cars cars, String expected) {
        // given: none

        // when, then
        assertThat(cars.toString()).isEqualTo(expected);
    }

    static Stream<Arguments> cars_to_string_parameter() {
        return Stream.of(
                Arguments.of(
                        new Cars(Arrays.asList(new Car("a", 1), new Car("b", 2), new Car("c", 3))),
                        "a : -" + StringUtils.NEW_LINE
                                + "b : --" + StringUtils.NEW_LINE
                                + "c : ---" + StringUtils.NEW_LINE),
                Arguments.of(
                        initialCars,
                        firstName + " : " + StringUtils.NEW_LINE
                                + secondName + " : " + StringUtils.NEW_LINE
                                + thirdName + " : " + StringUtils.NEW_LINE));
    }

    @DisplayName("자동차들 중, 가장 큰 위치값이 몇인지 판별한다.")
    @Test
    void get_largest_car_position() {
        // given
        int lessPosition1 = 1;
        int lessPosition2 = 2;
        int largestPosition = 3;

        Cars cars = new Cars(Arrays.asList(
                new Car(firstName, lessPosition1),
                new Car(secondName, lessPosition2),
                new Car(thirdName, largestPosition)));

        // when
        CarPosition largest = cars.getLargestCarPosition();

        // then
        assertThat(largest).isEqualTo(new CarPosition(largestPosition));
    }

}
