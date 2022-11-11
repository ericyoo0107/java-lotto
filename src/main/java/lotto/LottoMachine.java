package lotto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoMachine {
	private Lotto lottoNum;
	private int bonusNum;
	private int returnMoney;
	private Map result = new TreeMap<String, Integer>();

	public LottoMachine(List<Integer> lottoNum, int bonusNum) {
		this.lottoNum = new Lotto(lottoNum);
		this.bonusNum = bonusNum;
		this.returnMoney = 0;
		result.put("3개 일치 (5,000원)", 0);
		result.put("4개 일치 (50,000원)", 0);
		result.put("5개 일치 (1,500,000원)", 0);
		result.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
		result.put("6개 일치 (2,000,000,000원)", 0);
	}

	public void makeLottoResult(List<Lotto> userLotto) {
		for (Lotto lotto : userLotto) {
			List<Integer> userLottoList = lotto.getNumbers();
			compareNumber(lottoNum.getNumbers(), userLottoList);
		}
	}

	public void compareNumber(List<Integer> LottoNum, List<Integer> userLotto) {
		int count = 0;
		boolean bonusYN = false;
		for (int i = 0; i < userLotto.size(); i++) {
			if (LottoNum.contains(userLotto.get(i)))
				count++;
		}
		if (userLotto.contains(bonusNum))
			bonusYN = true;
		if (count == 3) {
			result.replace("3개 일치 (5,000원)", (int)result.get("3개 일치 (5,000원)") + 1);
			returnMoney += 5000;
		} else if (count == 4) {
			result.replace("4개 일치 (50,000원)", (int)result.get("4개 일치 (50,000원)") + 1);
			returnMoney += 50000;
		} else if (count == 5 && bonusYN == false) {
			result.replace("5개 일치 (1,500,000원)", (int)result.get("5개 일치 (1,500,000원)") + 1);
			returnMoney += 1500000;
		} else if (count == 5 && bonusYN == true) {
			result.replace("5개 일치, 보너스 볼 일치 (30,000,000원)", (int)result.get("5개 일치, 보너스 볼 일치") + 1);
			returnMoney += 30000000;
		} else if (count == 6) {
			result.replace("6개 일치 (2,000,000,000원)", (int)result.get("6개 일치 (2,000,000,000원)") + 1);
			returnMoney += 200000000;
		}
	}

	public void showResult() {
		result.forEach((key, value) -> System.out.println(key + " - " + value + "개"));
	}

	public int getReturnMoney() {
		return returnMoney;
	}
}
