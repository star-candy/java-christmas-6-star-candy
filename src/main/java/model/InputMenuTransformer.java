package model;

import DTO.OrderMenu;
import exception.InputValidator;
import java.util.ArrayList;
import java.util.List;

public class InputMenuTransformer {
    private final String inputMenu;
    private final List<String> menuName = new ArrayList<>();
    private final List<Integer> menuQuantity = new ArrayList<>();
    InputValidator inputValidator = new InputValidator();


    public InputMenuTransformer(String inputMenu) {
        this.inputMenu = inputMenu;
        inputMenuTransform();
        inputMenuValidate();
    }

    private void inputMenuTransform() {
        try {
            String[] menuBundles = inputMenu.split(",");
            for (String menuBundle : menuBundles) {
                String[] menuParts = menuBundle.split("-");
                if (menuParts.length == 2) {
                    menuName.add(menuParts[0]);
                    menuQuantity.add(Integer.parseInt(menuParts[1]));
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            menuQuantity.add(0);
        }
    }
    private void inputMenuValidate() {
        inputValidator.menuValidate(menuName, menuQuantity);
        OrderMenu.initializeOrderMenu(menuName, menuQuantity);
    }
}
