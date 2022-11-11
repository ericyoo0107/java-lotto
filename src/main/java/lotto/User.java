package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class User {
	private final List<Lotto> myLotto = new ArrayList<>();
	private int money;

	public User(int money) {
		moneyCheck(money);
		this.money = money;
	}

	public int moneyCheck(int money) {
		if (money % 1000 != 0)
			throw new IllegalArgumentException();
		return money;
	}

	public void buyLotto() {
		for (int i = money; i > 0; i -= 1000) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Lotto lotto = new Lotto(numbers);
			myLotto.add(lotto);
		}
	}

	public List<Lotto> getMyLotto() {
		return myLotto;
	}
}
