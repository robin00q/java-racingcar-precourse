package racingcar.car.domain.models;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.domain.errors.CarErrors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public static Cars initCarsByName(List<String> names) {
        validate(names);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }

    private static void validate(List<?> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(CarErrors.CARS_EMPTY_ERROR);
        }
    }
}
