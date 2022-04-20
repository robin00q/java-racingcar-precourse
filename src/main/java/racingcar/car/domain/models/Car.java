package racingcar.car.domain.models;

public class Car {

    private static final int INITIAL_CAR_POSITION = 0;

    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition(INITIAL_CAR_POSITION);
    }
}
