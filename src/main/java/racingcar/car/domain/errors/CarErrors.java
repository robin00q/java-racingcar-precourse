package racingcar.car.domain.errors;

public class CarErrors {

    public static final String CAR_NAME_EMPTY_ERROR = "[ERROR] 자동차 이름은 비어있을 수 없습니다.";
    public static final String CAR_NAME_GREATER_THAN_NAME_RULE_ERROR = "[ERROR] 자동차 이름 오류입니다. 최대 글자 수 : ";

    public static final String CAR_POSITION_LESS_THAN_ZERO_ERROR = "[ERROR] 자동차의 위치 오류입니다. 최소 자동차 위치 : ";

    public static final String CARS_EMPTY_ERROR = "[ERROR] 자동차를 최소 한대는 입력해야합니다.";

    private CarErrors() {
    }
}
