package racingcar.car.domain.models;

import java.util.Objects;
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

    public CarPosition moveForward() {
        return new CarPosition(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
