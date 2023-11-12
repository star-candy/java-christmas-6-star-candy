package model;

import DTO.OrderMenu;
import DTO.OrderMenu.OrderItem;
import java.util.ArrayList;
import java.util.List;
import exception.InputValidator;

public class InputMenuTransformer {
    private final String inputMenu;
    private final List<OrderItem> orderItems = new ArrayList<>();
    OrderMenu orderMenu;
    InputValidator inputValidator = new InputValidator();


    public InputMenuTransformer(String inputMenu) {
        this.inputMenu = inputMenu;
        inputMenuTransform();
    }

    public void inputMenuTransform() {
        String[] menuBundles = inputMenu.split(",");
        for (String menuBundle : menuBundles) {
            String[] menuParts = menuBundle.split("-");
            if (menuParts.length == 2) {
                String menuName = menuParts[0];
                int menuQuantity = Integer.parseInt(menuParts[1]);
                orderItems.add(new OrderItem(menuName, menuQuantity));
            }
        }
        inputValidator.menuValidate(orderItems);
        orderMenu = new OrderMenu(orderItems);
    }
}
