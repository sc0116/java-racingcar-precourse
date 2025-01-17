package racingcar;

import static utils.Message.*;
import static utils.validator.AttemptNumberValidator.*;
import static utils.validator.CarNameValidator.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {

	private List<String> carNames;
	private int attemptNumber;

	public void run() {
		inputCarNames();
		inputAttemptNumber();
		startRace(carNames, attemptNumber);
	}

	private void inputCarNames() {
		System.out.println(RACING_CAR_NAME_INPUT_MESSAGE);

		while (true) {
			try {
				String[] carNames = Console.readLine().split(",");
				validateCarName(carNames);

				this.carNames = Arrays.asList(carNames);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void inputAttemptNumber() {
		System.out.println(ATTEMPT_NUMBER_MESSAGE);

		while (true) {
			try {
				String attemptNumber = Console.readLine();
				validateAttemptNumber(attemptNumber);

				this.attemptNumber = Integer.parseInt(attemptNumber);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void startRace(List<String> carNames, int attemptNumber) {
		Race race = new Race(carNames, attemptNumber);
		race.run();
	}
}
