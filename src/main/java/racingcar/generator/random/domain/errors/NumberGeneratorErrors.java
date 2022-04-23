package racingcar.generator.random.domain.errors;

public class NumberGeneratorErrors {

    public static final String NUMBER_GENERATOR_STRATEGY_EMPTY_ERROR = "[ERROR] 숫자를 생성하기 위한 전략은 비어있을 수 없습니다.";
    public static final String NUMBER_GENERATOR_START_GREATER_THAN_END_INCLUSIVE =
            "[ERROR] 랜덤숫자 생성 시, 시작숫자보다 끝 수자가 클 수 없습니다.";
    public static final String GENERATED_NUMBER_LESS_THAN_START_INCLUSIVE = "[ERROR] 생성된 숫자가 시작숫자보다 작습니다.";
    public static final String GENERATED_NUMBER_GREATER_THAN_END_INCLUSIVE = "[ERROR] 생성된 숫자가 끝 숫자보다 큽니다.";


    private NumberGeneratorErrors() {
    }
}
