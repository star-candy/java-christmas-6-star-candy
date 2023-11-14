package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PreDiscountPaymentCalculatorTest {
    @Test
    void 할인전_총계산금액_출력_테스트() {
        //given
        List<String> menuName = List.of("초코케이크", "티본스테이크", "제로콜라");
        List<Integer> menuQuantity = List.of(1, 1, 1);
        //when
        PreDiscountPaymentCalculator preDiscountPaymentCalculator = new PreDiscountPaymentCalculator(menuName, menuQuantity);
        int totalPayment = preDiscountPaymentCalculator.preDiscountPaymentCalculate();
        //then
        assertThat(totalPayment).isEqualTo(73000);
    }
}