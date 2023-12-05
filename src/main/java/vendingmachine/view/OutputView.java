package vendingmachine.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vendingmachine.domain.Coin;

public class OutputView {

    public void showVendingMachineCoins(Map<Coin, Integer> coins) {
        System.out.println("자판기가 보유한 동전");
        List<Coin> keyList = new ArrayList<>(coins.keySet());
        keyList.sort((s1, s2) -> s2.getAmount() - s1.getAmount());
        Iterator<Coin> keys = keyList.iterator();
        while(keys.hasNext()) {
            Coin coin = keys.next();
            Integer amount = coins.get(coin);
            System.out.println(coin.getAmount() + "원 : " + amount + "개");
        }
    }

    public void printMoney(int money) {
        System.out.println("투입 금액: " + money);
    }
}
