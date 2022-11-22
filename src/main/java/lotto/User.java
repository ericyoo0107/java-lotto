package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Randoms;

public class User {
	private final List<Lotto> myLotto = new ArrayList<>();
	private int money;

	public User(String money) {
		moneyCheck(money);
		this.money = Integer.parseInt(money);
	}

	public void moneyCheck(String money) {
		for (int i = 0; i < money.length(); i++) {
			if (money.charAt(i) < '0' || money.charAt(i) > '9') {
				System.out.println("[ERROR] 돈은 1000원 단위로 지불해야합니다.");
				throw new NoSuchElementException("[ERROR] 돈은 1000원 단위로 지불해야합니다.");
			}
		}
		if (Integer.parseInt(money) % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 지불해야합니다.");
		}
	}

	public void buyLotto() {
		System.out.println(money / 1000 + "개를 구매했습니다.");
		for (int i = money; i > 0; i -= 1000) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Lotto lotto = new Lotto(numbers);
			myLotto.add(lotto);
		}
		for (Lotto lotto : myLotto) {
			System.out.println(lotto.getNumbers());
		}
	}

	public List<Lotto> getMyLotto() {
		return myLotto;
	}

	public int getMoney() {
		return money;
	}
}
