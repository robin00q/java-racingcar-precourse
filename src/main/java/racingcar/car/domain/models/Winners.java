package racingcar.car.domain.models;

import java.util.List;
import racingcar.car.domain.errors.CarErrors;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        validate(winners);
        this.winners = winners;
    }

    private void validate(List<Car> winners) {
        if (winners == null || winners.isEmpty()) {
            throw new IllegalStateException(CarErrors.WINNERS_EMPTY_ERROR);
        }
    }
}
