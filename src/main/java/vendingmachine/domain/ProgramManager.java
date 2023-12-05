package vendingmachine.domain;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ProgramManager {
    static InputView inputView;
    static OutputView outputView;
    static VendingMachine vendingMachine;
    public ProgramManager() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        // 자판기 보유금액 설정
        setMachineHoldingAmount();
        // 자판기 보유 동전 출력
        showVendingMachineCoins();
        // 상품등록
        setItemInMachine();
        // 투입금액 입력
        putMoney();
        // 상품 구매
        buyItem();
        // 잔돈 반환
        returnChange();
    }

    void setMachineHoldingAmount() {
        String input = inputView.getMachineHoldingAmount();
        vendingMachine = new VendingMachine(input);
    }

    void showVendingMachineCoins() {
        outputView.showVendingMachineCoins(vendingMachine.getCoins());
    }

    void setItemInMachine() {
        String input = inputView.getItemForMachine();
        vendingMachine.setItemInMachine(input);
    }

    void putMoney() {
        String input = inputView.getInputMoney();
        vendingMachine.setInputMoney(input);
    }

    void buyItem() {
        // 잔액이 상품가격 보다 높으면 계속.

        // 투입금액 출력
        // 상품명 입력
    }

    void returnChange() {
        // 투입금액 출력
        // 잔돈 출력
    }
}
