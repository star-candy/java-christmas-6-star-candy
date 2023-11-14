package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GiftRewardDeterminerTest {
    @Test
    void 증정이벤트_판단_테스트() {
        //given
        int preDiscountPayment = 120000;
        //when
        GiftRewardDeterminer giftRewardDeterminer = new GiftRewardDeterminer(preDiscountPayment);
        int validate = giftRewardDeterminer.giftRewardDetermine();
        int giftReward = 1;
        //then
        assertThat(validate).isEqualTo(giftReward);
    }
}