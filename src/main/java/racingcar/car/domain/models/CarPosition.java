package racingcar.car.domain.models;

import racingcar.car.domain.errors.CarErrors;

public class CarPosition {

    private static final int MINIMUM_CAR_POSITION = 0;

    private final int position;

    public CarPosition(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < MINIMUM_CAR_POSITION) {
            throw new IllegalArgumentException(CarErrors.CAR_POSITION_LESS_THAN_ZERO_ERROR);
        }
    }
}
