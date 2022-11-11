package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int userMoney = Integer.parseInt(Console.readLine());
        User JunHyuk = new User(userMoney);
        JunHyuk.buyLotto();

        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoNumString = Console.readLine();
        String[] lottoNumList = lottoNumString.split(",");
        List<Integer> lottoNumInt = new ArrayList<>();
        for (String s : lottoNumList) {
            lottoNumInt.add(Integer.parseInt(s));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        LottoMachine lottoMachine = new LottoMachine(lottoNumInt, Integer.parseInt(bonusNum));

        lottoMachine.makeLottoResult(JunHyuk.getMyLotto());
        System.out.println("당첨 통계");
        System.out.println("---");
        lottoMachine.showResult();
        double yield = lottoMachine.getReturnMoney() / userMoney;
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
