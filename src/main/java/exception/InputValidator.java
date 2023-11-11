package exception;

public class InputValidator {
    private static final int DATE_MAX = 31;
    private static final int DATE_MIN = 1;
    public void dateValidate(int date) {
        if(date > DATE_MAX || date < DATE_MIN) {
            throw new IllegalArgumentException();
        }
    }
}
