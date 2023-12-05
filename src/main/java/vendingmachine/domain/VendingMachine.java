package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VendingMachine {
    Map<Coin, Integer> coins = new HashMap<>();
    List<Item> stockList = new ArrayList<>();
    int inputMoney;

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

    void setItemInMachine(String input) {
        validateItem(input);
        List<String> inputToList = Arrays.asList(input.split(";"));
        for(String item : inputToList) {
            String temp2 = item.replaceAll("\\[", "");
            temp2 = temp2.replaceAll("\\]", "");
            List<String> items = Arrays.asList(temp2.split(","));
            stockList.add(new Item(items.get(0), Integer.parseInt(items.get(1)), Integer.parseInt(items.get(2))));
        }
    }

    void validateItem(String input) {

    }

    void setInputMoney(String inputMoney) {
        // 돈을 입력 받고, 잔돈을 저장.
        // 숫자 아니면 예외 발생
        this.inputMoney = Integer.parseInt(inputMoney);
    }

    Map<Coin, Integer> getCoins() {
        return coins;
    }
}
