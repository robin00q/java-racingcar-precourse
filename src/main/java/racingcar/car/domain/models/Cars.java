package racingcar.car.domain.models;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.domain.errors.CarErrors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        validate(names);

        cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validate(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(CarErrors.CARS_EMPTY_ERROR);
        }
    }
}
