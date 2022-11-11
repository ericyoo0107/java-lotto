package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		numberRange1_45(numbers);
		findSameNumber(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) { //숫자가 6개인지 체크
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	private void numberRange1_45(List<Integer> numbers) { //1~45가 아니라 다른 숫자 넣은 경우 에러발생
		for (Integer num : numbers) {
			if (num < 1 || num > 45) {
				System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
				throw new IllegalArgumentException();
			}
		}
	}

	private void findSameNumber(List<Integer> numbers) { //같은 숫자 들어왔을 경우 에러발생
		if (sameKiller(numbers).size() != numbers.size()) {
			System.out.println("[ERROR] 로또 번호는 같은 숫자가 있을수 없습니다.");
			throw new IllegalArgumentException();
		}
	}

	private List<Integer> sameKiller(List<Integer> numbers) {
		Set<Integer> killSame = new HashSet<>(numbers);
		List<Integer> noSameNow = new ArrayList<>(killSame);
		return noSameNow;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
