package model;

public class GiftRewardDeterminer {
    private final static int GIFT_OFFER_POINT = 120000;
    private final static int GIFT_REWARD = 1;
    private final static int NOT_GIFT_REWARD = 0;
    private final int preDiscountPayment;

    public GiftRewardDeterminer(int preDiscountPayment) {
        this.preDiscountPayment = preDiscountPayment;
    }

    public int giftRewardDetermine() {
        if (preDiscountPayment >= GIFT_OFFER_POINT) {
            return GIFT_REWARD;
        }
        return NOT_GIFT_REWARD;
    }
}