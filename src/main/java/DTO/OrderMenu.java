package DTO;

import java.util.List;

public class OrderMenu {
    private final List<String> menuName;
    private final List<Integer> menuQuantity;

    public OrderMenu(List<String> menuName, List<Integer> menuQuantity) {
        this.menuName = menuName;
        this.menuQuantity = menuQuantity;
    }

    public List<String> getMenuName() {
        return menuName;
    }

    public List<Integer> getMenuQuantity() {
        return menuQuantity;
    }

}