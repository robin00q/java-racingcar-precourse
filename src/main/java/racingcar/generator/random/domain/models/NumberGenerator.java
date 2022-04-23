package racingcar.generator.random.domain.models;

import java.util.Objects;
import racingcar.generator.random.domain.errors.NumberGeneratorErrors;
import racingcar.generator.random.domain.external.NumberGenerateStrategy;

public class NumberGenerator {

    private final int generated;

    public NumberGenerator(int generated) {
        this.generated = generated;
    }

    public static NumberGenerator generateNumberInRangeInclusively(
            NumberGenerateStrategy strategy, int startInclusive, int endInclusive) {
        validate(strategy);
        validate(startInclusive, endInclusive);

        int generated = strategy.generateNumberInRangeInclusively(startInclusive, endInclusive);

        validate(generated, startInclusive, endInclusive);

        return new NumberGenerator(generated);
    }

    private static void validate(int startInclusive, int endInclusive) {
        if (endInclusive < startInclusive) {
            throw new IllegalStateException(NumberGeneratorErrors.NUMBER_GENERATOR_START_GREATER_THAN_END_INCLUSIVE);
        }
    }

    private static void validate(NumberGenerateStrategy strategy) {
        if (strategy == null) {
            throw new IllegalStateException(NumberGeneratorErrors.NUMBER_GENERATOR_STRATEGY_EMPTY_ERROR);
        }
    }

    private static void validate(int generated, int startInclusive, int endInclusive) {
        if (generated < startInclusive) {
            throw new IllegalStateException(NumberGeneratorErrors.GENERATED_NUMBER_LESS_THAN_START_INCLUSIVE);
        }
        if (generated > endInclusive) {
            throw new IllegalStateException(NumberGeneratorErrors.GENERATED_NUMBER_GREATER_THAN_END_INCLUSIVE);
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NumberGenerator that = (NumberGenerator) o;
        return generated == that.generated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(generated);
    }
}
