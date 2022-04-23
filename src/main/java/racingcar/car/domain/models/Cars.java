package racingcar.car.domain.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.car.domain.errors.CarErrors;
import racingcar.car.domain.external.CarMovePolicyStrategy;
import racingcar.util.StringUtils;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
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

    public Cars moveForward(CarMovePolicyStrategy strategy) {
        List<Car> movedCars = new ArrayList<>();

        for (Car car : cars) {
            movedCars.add(car.moveForward(strategy));
        }

        return new Cars(movedCars);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Car car : cars) {
            builder.append(car.toString()).append(StringUtils.NEW_LINE);
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
