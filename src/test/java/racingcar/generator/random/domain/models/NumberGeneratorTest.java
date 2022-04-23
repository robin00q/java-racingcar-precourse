package racingcar.generator.random.domain.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.generator.random.domain.errors.NumberGeneratorErrors;
import racingcar.generator.random.domain.external.NumberGenerateStrategy;

class NumberGeneratorTest {

    @DisplayName("랜덤값 생성 도메인 객체를 생성한다.")
    @Test
    void create_number_generator_domain() {
        // given: none

        // when
        NumberGenerator numberGenerator = NumberGenerator.
                generateNumberInRangeInclusively((startInclusive, endInclusive) -> 1, 1, 1);

        // then
        assertThat(numberGenerator).isEqualTo(new NumberGenerator(1));
    }

    @DisplayName("랜덤값 생성 도메인 객체 생성 시, 전략이 없는경우 예외가 발생한다.")
    @Test
    void create_number_generator_domain_without_strategy() {
        // given: none

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(() -> NumberGenerator.generateNumberInRangeInclusively(null, 1, 1))
                .withMessage(NumberGeneratorErrors.NUMBER_GENERATOR_STRATEGY_EMPTY_ERROR);
    }

    @DisplayName("랜덤값 생성 도메인 객체 생성 시, startInclusive 값이 endInclusive 보다 큰 경우, 예외가 발생한다.")
    @Test
    void create_number_generator_domain_startInclusive_greater_than_endInclusive() {
        // given
        int startInclusive = 10;
        int endInclusive = 9;

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(() -> NumberGenerator.generateNumberInRangeInclusively(
                        (startInclusive1, endInclusive1) -> 9, startInclusive, endInclusive))
                .withMessage(NumberGeneratorErrors.NUMBER_GENERATOR_START_GREATER_THAN_END_INCLUSIVE);
    }

    @ParameterizedTest(name = "생성된 숫자가 startInclusive 보다 작거나, endInclusive 보다 큰 경우, 예외가 발생한다.")
    @MethodSource("create_number_in_range_is_not_between_range_parameter")
    void create_number_in_range_is_not_between_range(
            NumberGenerateStrategy strategy, int startInclusive, int endInclusive, String expectedErrorMsg) {
        // given: none

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(() ->
                        NumberGenerator.generateNumberInRangeInclusively(strategy, startInclusive, endInclusive))
                .withMessage(expectedErrorMsg);
    }

    static Stream<Arguments> create_number_in_range_is_not_between_range_parameter() {
        int start = 1;
        int end = 9;
        return Stream.of(
                Arguments.of(
                        (NumberGenerateStrategy) (startInclusive, endInclusive) -> 10,
                        start, end,
                        NumberGeneratorErrors.GENERATED_NUMBER_GREATER_THAN_END_INCLUSIVE),
                Arguments.of(
                        (NumberGenerateStrategy) (startInclusive, endInclusive) -> 0,
                        start, end,
                        NumberGeneratorErrors.GENERATED_NUMBER_LESS_THAN_START_INCLUSIVE));
    }
}