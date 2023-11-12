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
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run() {
        outputView.startNotify();
        InputDateTransformer inputDateTransformer = new InputDateTransformer(inputView.reservedDate());
        InputMenuTransformer inputMenuTransformer = new InputMenuTransformer(inputView.orderMenu());
        outputView.endNotify();
        outputView.printOrder(OrderMenu.getMenuName(), OrderMenu.getMenuQuantity());

        PreDiscountPaymentCalculator preDiscountPaymentCalculator = new PreDiscountPaymentCalculator(
                OrderMenu.getMenuName(), OrderMenu.getMenuQuantity());
        GiftRewardDeterminer giftRewardDeterminer = new GiftRewardDeterminer(
                PreDiscountPayment.getPreDiscountPayment());
        DiscountCalculator discountCalculator = new DiscountCalculator(ReservedDate.getReservedDate(),
                GiftReward.getGiftReward(), OrderMenu.getMenuName(), OrderMenu.getMenuQuantity());

        outputView.preDiscountPayment(PreDiscountPayment.getPreDiscountPayment());
        outputView.giftReward(GiftReward.getGiftReward());
        outputView.discountDetails(DiscountDetails.getDiscountName(), DiscountDetails.getDiscountQuantity());
        outputView.totalDiscountPayment(TotalDiscountMoney.getTotalDiscountMoney());
        outputView.totalPayment(PreDiscountPayment.getPreDiscountPayment(), TotalDiscountMoney.getTotalDiscountMoney(),
                GiftReward.getGiftReward());
        outputView.eventBadge(EventBadge.getEventBadge());
    }
}