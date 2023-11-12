package exception;

import DTO.OrderMenu.OrderItem;
import constants.Description;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputValidator {
    private static final int DATE_MAX = 31;
    private static final int DATE_MIN = 1;

    public void dateValidate(int date) {
        if(date > DATE_MAX || date < DATE_MIN) {
            throw new IllegalArgumentException(Description.ERROR_DATE.getMessage());
        }
    }

    public void menuValidate(List<OrderItem> orderItems) {
    List<String> menuName = getMenuNameList(orderItems);
    checkDuplicateMenu(menuName);
    checkOnlyDrinkMenu(menuName);
    List<Integer> menuQuantity = getMenuQuantityList(orderItems);
    checkMenuMax(menuQuantity);

    }

    // orderItems를 menuNameList로 변환하는 메서드
    private List<String> getMenuNameList(List<OrderItem> orderItems) {
        List<String> menuNameList = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            menuNameList.add(orderItem.menuName());
        }
        return menuNameList;
    }

    private void checkDuplicateMenu(List<String> menuName) {
        HashSet<String> set = new HashSet<>(menuName);
        if(set.size() < menuName.size()) {
            throw new IllegalArgumentException(Description.ERROR_MENU_DUPLICATE.getMessage());
        }
    }

    private void checkOnlyDrinkMenu(List<String> menuName) {
        List<String> drink = List.of(Description.DRINK.getMessage());
        if(menuName.size() <= 3 && drink.containsAll(menuName)) {

            throw new IllegalArgumentException(Description.ERROR_ONLY_DRINK.getMessage());
        }
    }

    // orderItems를 menuQuantityList로 변환하는 메서드
    public List<Integer> getMenuQuantityList(List<OrderItem> orderItems) {
        List<Integer> menuQuantityList = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            menuQuantityList.add(orderItem.quantity());
        }
        return menuQuantityList;
    }

    private void checkMenuMax(List<Integer> menuQuantity) {
        int quantity = 0;
        for (Integer integer : menuQuantity) {
            quantity += integer;
        }
        if(quantity > 20) {
            throw new IllegalArgumentException(Description.ERROR_MENU_FULL.getMessage());
        }
    }
}

