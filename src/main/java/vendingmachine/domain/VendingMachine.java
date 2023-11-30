package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VendingMachine {
    Map<Coin, Integer> coins = new HashMap<>();

    VendingMachine(String initialChange) {
        setMachineRandomCoinAmount(Integer.parseInt(initialChange));
    }

    void setMachineRandomCoinAmount(int change) {
        for(Coin coin : Arrays.asList(Coin.values())) {
            int max = change / coin.getAmount();

            List<Integer> range = IntStream.range(1, max+1)
                                        .boxed()
                                        .collect(Collectors.toList());
            if(range.isEmpty()) {
                range = Arrays.asList(0);
            }
            int random = Randoms.pickNumberInList(range);
            coins.put(coin, random);
            change -= coin.getAmount() * random;
        }
        coins.put(Coin.COIN_10, coins.get(Coin.COIN_10) + (change / Coin.COIN_10.getAmount()));
    }
}
