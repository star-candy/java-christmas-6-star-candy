package exception;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    void 날짜_예외처리_작동_테스트() {
        int date = 33;
        InputValidator inputValidator = new InputValidator();
        assertThrows(IllegalArgumentException.class, () -> inputValidator.dateValidate(date));
    }

    @Test
    void 메뉴_최댓값_입력_테스트() {
        List<Integer> menuQuantity = List.of(10, 2, 3, 10);
        InputValidator inputValidator = new InputValidator();
        assertThrows(IllegalArgumentException.class, () -> inputValidator.menuQuantityValidate(menuQuantity));
    }

}