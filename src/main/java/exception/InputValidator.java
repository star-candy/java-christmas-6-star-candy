package exception;

import constants.Description;
import java.util.HashSet;
import java.util.List;

public class InputValidator {
    private static final int DATE_MAX = 31;
    private static final int DATE_MIN = 1;

    public void dateValidate(int date) {
        if (date > DATE_MAX || date < DATE_MIN) {
            throw new IllegalArgumentException(Description.ERROR_DATE.getMessage());
        }
    }

    public void menuValidate(List<String> menuName, List<Integer> menuQuantity) {
        checkDuplicateMenu(menuName);
        checkOnlyDrinkMenu(menuName);
        checkMenuMax(menuQuantity);

    }


    private void checkDuplicateMenu(List<String> menuName) {
        HashSet<String> set = new HashSet<>(menuName);
        if (set.size() < menuName.size()) {
            throw new IllegalArgumentException(Description.ERROR_MENU_DUPLICATE.getMessage());
        }
    }

    private void checkOnlyDrinkMenu(List<String> menuName) {
        List<String> drink = List.of(Description.DRINK.getMessage());
        if (menuName.size() <= 3 && drink.containsAll(menuName)) {

            throw new IllegalArgumentException(Description.ERROR_ONLY_DRINK.getMessage());
        }
    }


    private void checkMenuMax(List<Integer> menuQuantity) {
        int quantity = 0;
        for (Integer integer : menuQuantity) {
            quantity += integer;
        }
        if (quantity > 20) {
            throw new IllegalArgumentException(Description.ERROR_MENU_FULL.getMessage());
        }
    }
}

