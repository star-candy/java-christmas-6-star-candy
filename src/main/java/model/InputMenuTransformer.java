package model;

import constants.Description;
import exception.InputValidator;
import java.util.ArrayList;
import java.util.List;

public class InputMenuTransformer {
    private final static int NAME_QUANTITY_PART = 2;
    private final static int FIRST_INDEX = 0;
    private final static int SECOND_INDEX = 1;
    private final static int ZERO_COUNT = 0;
    private final static String SPLIT_MENU_BUNDLE = ",";
    private final static String SPLIT_NAME_QUANTITY = "-";

    private final String inputMenu;
    private final List<String> menuName = new ArrayList<>();
    private final List<Integer> menuQuantity = new ArrayList<>();
    InputValidator inputValidator = new InputValidator();


    public InputMenuTransformer(String inputMenu) {
        this.inputMenu = inputMenu;
        inputMenuTransform();
    }

    private void inputMenuTransform() {
        try {
            String[] menuBundles = inputMenu.split(SPLIT_MENU_BUNDLE);
            for (String menuBundle : menuBundles) {
                String[] menuParts = menuBundle.split(SPLIT_NAME_QUANTITY);
                if (menuParts.length == NAME_QUANTITY_PART) {
                    menuName.add(menuParts[FIRST_INDEX]);
                    menuQuantity.add(Integer.parseInt(menuParts[SECOND_INDEX]));
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Description.ERROR_NO_MENU);
            menuQuantity.add(ZERO_COUNT);
        }
    }

    public List<String> inputMenuNameValidate() {
        inputValidator.menuNameValidate(menuName);
        return menuName;
    }

    public List<Integer> inputMenuQuantityValidate() {
        inputValidator.menuQuantityValidate(menuQuantity);
        return menuQuantity;
    }
}
