package model;

import exception.InputValidator;
import DTO.ReservedDate;

public class InputDateTransformer {
    private final String inputDate;
    InputValidator inputValidator = new InputValidator();
    ReservedDate reservedDate;

    public InputDateTransformer(String inputDate) {
        this.inputDate = inputDate;
        inputDateTransform();
    }

    public void inputDateTransform() {
        final int validateDate = Integer.parseInt(inputDate);
        inputValidator.dateValidate(validateDate);
        ReservedDate.initializeReservedDate(validateDate);
    }

}
