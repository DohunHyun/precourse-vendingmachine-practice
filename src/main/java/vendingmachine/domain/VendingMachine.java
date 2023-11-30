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
        int change = validateChange(initialChange);
        setMachineRandomCoinAmount(change);
    }

    int validateChange(String initialChange) {
        int change = Integer.parseInt(initialChange);
        // throw exception 숫자 아님
        if(change % 10 == 0) {
            return change;
        }
        // throw exception 10원 단위
        return change;
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
