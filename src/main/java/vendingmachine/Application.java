package vendingmachine;

import vendingmachine.domain.ProgramManager;

public class Application {
    public static void main(String[] args) {
        ProgramManager programManager = new ProgramManager();
        programManager.run();
    }
}
