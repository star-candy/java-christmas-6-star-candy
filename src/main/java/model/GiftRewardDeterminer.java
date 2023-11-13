package model;

public class GiftRewardDeterminer {
    private final int preDiscountPayment;

    public GiftRewardDeterminer(int preDiscountPayment) {
        this.preDiscountPayment = preDiscountPayment;

    }

    public int giftRewardDetermine() {
        if(preDiscountPayment >= 120000) {
            return 1;
        }
        return 0;
    }
}
