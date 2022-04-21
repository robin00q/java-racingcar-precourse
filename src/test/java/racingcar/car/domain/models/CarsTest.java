package racingcar.car.domain.models;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.car.domain.errors.CarErrors;

class CarsTest {

    @DisplayName("자동차들 객체를 생성한다.")
    @Test
    void create_cars() {
        // given
        String first = "lee";
        String second = "suk";
        String third = "june";

        // when, then
        assertThatCode(() -> new Cars(Arrays.asList(first, second, third)))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "자동차들 객체를 비정상적으로 생성한다.")
    @MethodSource("create_cars_invalid_parameter")
    void create_cars_invalid(List<String> cars) {
        // given: none

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(cars))
                .withMessage(CarErrors.CARS_EMPTY_ERROR);
    }

    static Stream<List<String>> create_cars_invalid_parameter() {
        return Stream.of(null, Collections.emptyList());
    }


}
