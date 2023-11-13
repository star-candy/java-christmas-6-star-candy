package controller;

import constants.Description;
import model.DiscountCalculator;
import model.GiftRewardDeterminer;
import model.InputDateTransformer;
import model.InputMenuTransformer;
import model.PreDiscountPaymentCalculator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ChristmasManager {
    private final OutputView outputView;
    private final InputView inputView;
    private int inputDate;
    private List<String> menuName;
    private List<Integer> menuQuantity;
    private int preDiscountPayment;
    private int giftReward;

    private int totalDiscount;
    private String badgeName;

    private static final int DISCOUNT_THRESHOLD = 10000;

    public ChristmasManager(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        notifyStartAndTransformInput();
        printOrder();
        calculatePreDiscountPayment();
        determineGiftRewardAndCalculateDiscount();
        printResults();
    }

    private void determineGiftRewardAndCalculateDiscount() {
        if (preDiscountPayment >= DISCOUNT_THRESHOLD) {
            determineGiftReward();
            calculateDiscount();
        } else {
            noDiscountPrintResult();
        }
    }

    private void notifyStartAndTransformInput() {
        outputView.startNotify();
        try {
            InputDateTransformer inputDateTransformer = new InputDateTransformer(inputView.reservedDate());
            inputDate = inputDateTransformer.inputDateTransform();
        } catch (IllegalArgumentException e) {
            System.out.println(Description.ERROR_DATE.getMessage());
        }
        InputMenuTransformer inputMenuTransformer = new InputMenuTransformer(inputView.orderMenu());
        menuName = inputMenuTransformer.inputMenuNameValidate();
        menuQuantity = inputMenuTransformer.inputMenuQuantityValidate();
        outputView.endNotify();
    }

    private void printOrder() {
        outputView.printOrder(menuName, menuQuantity);
    }

    private void calculatePreDiscountPayment() {
        PreDiscountPaymentCalculator preDiscountPaymentCalculator = new PreDiscountPaymentCalculator(menuName, menuQuantity);
        preDiscountPayment = preDiscountPaymentCalculator.preDiscountPaymentCalculate();
        outputView.preDiscountPayment(preDiscountPayment);
    }

    private void determineGiftReward() {
        GiftRewardDeterminer giftRewardDeterminer = new GiftRewardDeterminer(preDiscountPayment);
        giftReward = giftRewardDeterminer.giftRewardDetermine();
        outputView.giftReward(giftReward);
    }

    private void calculateDiscount() {
        DiscountCalculator discountCalculator = new DiscountCalculator(inputDate, giftReward, menuName, menuQuantity);
        List<String> discountName = discountCalculator.getDiscountName();
        List<Integer> discountPayments = discountCalculator.getDiscountPayments();
        badgeName = discountCalculator.getBadgeName();
        totalDiscount = discountCalculator.getTotalDiscount();

        outputView.discountDetails(discountName, discountPayments);
        outputView.totalDiscountPayment(totalDiscount);
    }

    private void printResults() {
        outputView.totalPayment(preDiscountPayment, totalDiscount, giftReward);
        outputView.eventBadge(badgeName);
    }

    private void noDiscountPrintResult() {
        outputView.noDiscountPrint(preDiscountPayment);
    }
}