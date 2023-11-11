package view;

import camp.nextstep.edu.missionutils.Console;
import constants.Description;

public class InputView {
    public String reservedDate() {
        System.out.println(Description.INPUT_DATE_NOTIFY.getMessage());
        String dateInput = Console.readLine();
        System.out.println(dateInput);
        return dateInput;
    }
}
