package model;

import constants.Description;
import exception.InputValidator;

public class InputDateTransformer {
    private final String inputDate;
    InputValidator inputValidator = new InputValidator();

    public InputDateTransformer(String inputDate) {
        this.inputDate = inputDate;
    }

    public int inputDateTransform() { //controller 사용시 Description.ERROR_DATE.getMessage()에 대한 try-catch 사용하기
        final int validateDate = Integer.parseInt(inputDate);
        inputValidator.dateValidate(validateDate);
        return validateDate;
    }
}