package christmas;

import controller.ChristmasManager;
import view.OutputView;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        ChristmasManager christmasManager = new ChristmasManager(outputView, inputView);
        christmasManager.run();
    }
}
