package racingcar.car.domain.models;

import java.util.List;
import java.util.StringJoiner;
import racingcar.car.domain.errors.CarErrors;
import racingcar.util.StringUtils;

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

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(StringUtils.COMMA + StringUtils.SPACE);

        for (Car winner : winners) {
            joiner.add(winner.getCarName());
        }

        return joiner.toString();
    }
}
