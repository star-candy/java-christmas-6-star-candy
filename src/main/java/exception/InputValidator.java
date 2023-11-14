package exception;

import constants.Description;
import java.util.HashSet;
import java.util.List;

public class InputValidator {
    private static final int DATE_MAX = 31;
    private static final int DATE_MIN = 1;
    private static final int DRINK_FULL = 3;
    private static final int RESET = 0;
    private static final int MENU_MAX = 20;
    private static final List<String> DRINK = List.of("제로콜라", "레드와인", "샴페인");

    public void dateValidate(int date) {
        if (date > DATE_MAX || date < DATE_MIN) {
            throw new IllegalArgumentException();
        }
    }

    public void menuNameValidate(List<String> menuName) {
        checkDuplicateMenu(menuName);
        checkOnlyDrinkMenu(menuName);
    }

    public void menuQuantityValidate(List<Integer> menuQuantity) {
        checkMenuMax(menuQuantity);
    }

    private void checkDuplicateMenu(List<String> menuName) {
        HashSet<String> set = new HashSet<>(menuName);
        try {
            if (set.size() < menuName.size()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Description.ERROR_MENU_DUPLICATE.getMessage());
        }
    }

    private void checkOnlyDrinkMenu(List<String> menuName) {
        try {
            if (menuName.size() <= DRINK_FULL && new HashSet<>(DRINK).containsAll(menuName)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Description.ERROR_ONLY_DRINK.getMessage());
        }
    }

    private void checkMenuMax(List<Integer> menuQuantity) {
        int quantity = RESET;
        for (Integer integer : menuQuantity) {
            quantity += integer;
        }
        if (quantity > MENU_MAX) {
            throw new IllegalArgumentException(Description.ERROR_MENU_FULL.getMessage());
        }
    }
}

