package controller;

import DTO.DiscountDetails;
import DTO.EventBadge;
import DTO.GiftReward;
import DTO.OrderMenu;
import DTO.PreDiscountPayment;
import DTO.ReservedDate;
import DTO.TotalDiscountMoney;
import model.DiscountCalculator;
import model.GiftRewardDeterminer;
import model.InputDateTransformer;
import model.InputMenuTransformer;
import model.PreDiscountPaymentCalculator;
import view.InputView;
import view.OutputView;

public class ChristmasManager {
    private final OutputView outputView;
    private final InputView inputView;

    public ChristmasManager(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        notifyStartAndTransformInput();
        printOrder();
        calculatePreDiscountPayment();
        if (PreDiscountPayment.getPreDiscountPayment() < 10000) {
            noDiscountPrintResult();
        }
        if (PreDiscountPayment.getPreDiscountPayment() >= 10000) {
            determineGiftReward();
            calculateDiscount();
            printResults();
        }
    }

    private void notifyStartAndTransformInput() {
        outputView.startNotify();
        InputDateTransformer inputDateTransformer = new InputDateTransformer(inputView.reservedDate());
        InputMenuTransformer inputMenuTransformer = new InputMenuTransformer(inputView.orderMenu());
        outputView.endNotify();
    }

    private void printOrder() {
        outputView.printOrder(OrderMenu.getMenuName(), OrderMenu.getMenuQuantity());
    }

    private void calculatePreDiscountPayment() {
        PreDiscountPaymentCalculator preDiscountPaymentCalculator = new PreDiscountPaymentCalculator(
                OrderMenu.getMenuName(), OrderMenu.getMenuQuantity());
        outputView.preDiscountPayment(PreDiscountPayment.getPreDiscountPayment());
    }

    private void determineGiftReward() {
        GiftRewardDeterminer giftRewardDeterminer = new GiftRewardDeterminer(
                PreDiscountPayment.getPreDiscountPayment());
        outputView.giftReward(GiftReward.getGiftReward());
    }

    private void calculateDiscount() {
        DiscountCalculator discountCalculator = new DiscountCalculator(ReservedDate.getReservedDate(),
                GiftReward.getGiftReward(), OrderMenu.getMenuName(), OrderMenu.getMenuQuantity());
        outputView.discountDetails(DiscountDetails.getDiscountName(), DiscountDetails.getDiscountQuantity());
        outputView.totalDiscountPayment(TotalDiscountMoney.getTotalDiscountMoney());
    }

    private void printResults() {
        outputView.totalPayment(PreDiscountPayment.getPreDiscountPayment(),
                TotalDiscountMoney.getTotalDiscountMoney(), GiftReward.getGiftReward());
        outputView.eventBadge(EventBadge.getEventBadge());
    }
    private void noDiscountPrintResult() {
        outputView.noDiscountPrint(PreDiscountPayment.getPreDiscountPayment());
    }
}