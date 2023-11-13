package model;

import constants.Description;
import exception.InputValidator;
import DTO.ReservedDate;

public class InputDateTransformer {
    private final String inputDate;
    InputValidator inputValidator = new InputValidator();

    public InputDateTransformer(String inputDate) {
        this.inputDate = inputDate;
        inputDateTransform();
    }

    public void inputDateTransform() {
        try {
            final int validateDate = Integer.parseInt(inputDate);
            inputValidator.dateValidate(validateDate);
            ReservedDate.initializeReservedDate(validateDate);
        } catch (IllegalArgumentException e) {
            System.out.println(Description.ERROR_DATE.getMessage());

        }
    }
}