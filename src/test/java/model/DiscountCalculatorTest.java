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
        List<Integer> discountPayments = discountCalculator.getDiscountPayments();
        for (Integer discountPayment : discountPayments) {
            discountValidate += discountPayment;
        }
        //then
        assertThat(totalDiscount).isEqualTo(discountValidate);
    }

    @Test
    void 주말_평일_할인_정상출력_테스트() {
        //given
        int date = 21;
        int gift = 1;
        List<String> menuName = List.of("초코케이크", "티본스테이크", "제로콜라");
        List<Integer> menuQuantity = List.of(1, 1, 1);
        //when
        DiscountCalculator discountCalculator = new DiscountCalculator(date, gift, menuName, menuQuantity);
        int validate = 0;
        List<Integer> validateList = discountCalculator.getDiscountPayments();
        validate = validateList.get(1);
        //then
        assertThat(validate).isEqualTo(2023);

    }

    @Test
    void 증정이벤트_정상출력_테스트() {
        //given
        int date = 21;
        int gift = 1;
        List<String> menuName = List.of("초코케이크", "티본스테이크", "제로콜라");
        List<Integer> menuQuantity = List.of(3, 3, 3);
        //when
        DiscountCalculator discountCalculator = new DiscountCalculator(date, gift, menuName, menuQuantity);
        int validate = 0;
        List<Integer> validateList = discountCalculator.getDiscountPayments();
        validate = validateList.get(2);
        //then
        assertThat(validate).isEqualTo(25000);

    }

    @Test
    void 배지_정상출력_테스트() {

    }
}