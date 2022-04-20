package racingcar.car.domain.models;

import racingcar.car.domain.errors.CarErrors;
import racingcar.util.StringUtils;

public class CarName {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || StringUtils.removeSpace(name).isEmpty()) {
            throw new IllegalArgumentException(CarErrors.CAR_NAME_EMPTY_ERROR);
        }

        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CarErrors.CAR_NAME_GREATER_THAN_NAME_RULE_ERROR + MAX_CAR_NAME_LENGTH);
        }
    }
}
