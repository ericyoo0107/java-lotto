package lotto;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoMachineTest {
	@Test
	void createLottoByDuplicatedNumber() {
		List<Integer> lottoNum = Arrays.asList(1, 2, 3, 4, 5, 6);
		LottoMachine lottoMachine = new LottoMachine(lottoNum,7);

		User user =new User("100000");
		user.buyLotto();

		lottoMachine.makeLottoResult(user.getMyLotto());
		System.out.println(lottoMachine.getReturnMoney());
		System.out.println(user.getMoney());
		lottoMachine.showResult();
	}
}
