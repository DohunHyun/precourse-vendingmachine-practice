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

    void setItemInMachine() {
        String input = inputView.getItemForMachine();
        vendingMachine.setItemInMachine(input);
    }

    void putMoney() {

    }

    void buyItem() {

    }

    void returnChange() {

    }
}
