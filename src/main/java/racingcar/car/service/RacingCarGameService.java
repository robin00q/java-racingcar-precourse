package racingcar.car.service;

import racingcar.car.domain.external.CarMovePolicyStrategy;
import racingcar.car.domain.models.Cars;
import racingcar.car.service.dto.RacingCarPlayerCommand;

public class RacingCarGameService {

    private final CarMovePolicyStrategy strategy;

    public RacingCarGameService(CarMovePolicyStrategy strategy) {
        this.strategy = strategy;
    }

    public void play(RacingCarPlayerCommand command) {
        Cars initialCars = Cars.initCarsByName(command.getNames());
        Cars winners = playAsManyTimesAsTryCount(command, initialCars).getWinners();
    }

    private Cars playAsManyTimesAsTryCount(RacingCarPlayerCommand command, Cars cars) {
        int time = 0;

        do {
            System.out.println(cars);
            cars = cars.moveForward(strategy);
        } while (++time < command.getTryCount());

        return cars;
    }

}
