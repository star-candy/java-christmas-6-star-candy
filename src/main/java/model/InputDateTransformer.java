package model;

import exception.InputValidator;

public class InputDateTransformer {
    private final String inputDate;
    InputValidator inputValidator = new InputValidator();

    public InputDateTransformer(String inputDate) {
        this.inputDate = inputDate;
    }

    public int inputDateTransform() {
        final int validateDate = Integer.parseInt(inputDate);
        inputValidator.dateValidate(validateDate);
        return validateDate;
    }
}