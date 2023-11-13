package exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class InputValidatorTest {
    @Test
    void 날짜_예외처리_작동_테스트() {
        //given
        int date = 33;
        //when
        InputValidator inputValidator = new InputValidator();
        assertThrows(IllegalArgumentException.class, () -> inputValidator.dateValidate(date));
    }

}