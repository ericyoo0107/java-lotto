package lotto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LottoMachine {
	private Lotto lottoNum;
	private int bonusNum;
	private int returnMoney;
	private Map result;

	public LottoMachine(List<Integer> lottoNum, int bonusNum)
	{
		this.lottoNum=new Lotto(lottoNum);
		this.bonusNum=bonusNum;
		this.returnMoney=0;
		result=new HashMap<String, Integer>();
		result.put("3개 일치 (5,000원)", 0);
		result.put("4개 일치 (50,000원)", 0);
		result.put("5개 일치 (1,500,000원)", 0);
		result.put("5개 일치, 보너스 볼 일치", 0);
		result.put("6개 일치 (2,000,000,000원)", 0);
	}

	public void makeLottoResult(List<Lotto> userLotto)
	{

	}

	public void showResult() {
		Iterator<String> value = result.values().iterator();
		Iterator<String> key = result.keySet().iterator();
		while (value.hasNext() && key.hasNext()) {
			System.out.println(value + " - " + key + "개");
		}
	}

	public int getReturnMoney() {
		return returnMoney;
	}
}
