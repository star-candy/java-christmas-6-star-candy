package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class DiscountCalculatorTest {
    @Test
    void 할인목록_총할인내역_교차검증_테스트() {
        //given
        int date = 21;
        int gift = 1;
        List<String> menuName = List.of("양송이수프", "티본스테이크", "제로콜라");
        List<Integer> menuQuantity = List.of(3, 2, 1);
        //when
        DiscountCalculator discountCalculator = new DiscountCalculator(date, gift, menuName, menuQuantity);
        int totalDiscount = discountCalculator.getTotalDiscount();
        int discountValidate = 0;
        List<Integer> discountPayments =  discountCalculator.getDiscountPayments();
        for (Integer discountPayment : discountPayments) {
            discountValidate += discountPayment;
        }
        //then
        assertThat(totalDiscount).isEqualTo(discountValidate);
    }



}