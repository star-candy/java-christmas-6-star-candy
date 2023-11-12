package model;

import DTO.GiftReward;

public class GiftRewardDeterminer {
    private final int preDiscountPayment;
    GiftReward giftReward;

    GiftRewardDeterminer(int preDiscountPayment) {
        this.preDiscountPayment = preDiscountPayment;
        giftRewardDetermine();
    }

    private void giftRewardDetermine() {
        if(preDiscountPayment >= 120000) {
            giftReward = new GiftReward(1);
        }
    }
}
