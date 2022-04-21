package racingcar.car.domain.models;

import java.util.Objects;

public class Car {

    private static final int INITIAL_CAR_POSITION = 0;

    private final CarName name;
    private final CarPosition position;

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition(INITIAL_CAR_POSITION);
    }

    private Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public Car moveForward(CarMovePolicy movePolicy) {
        if (movePolicy.isMove()) {
            return new Car(name, position.moveForward());
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
