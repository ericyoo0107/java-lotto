package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numberRange1_45(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) { //숫자가 6개인지 체크
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void numberRange1_45(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
