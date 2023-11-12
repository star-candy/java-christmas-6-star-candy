package DTO;

import java.util.List;

public class OrderMenu {
    private static List<String> menuName;
    private static List<Integer> menuQuantity;

    // 정적 메서드로 생성자 대체
    public static void initializeOrderMenu(List<String> names, List<Integer> quantities) {
        menuName = names;
        menuQuantity = quantities;
    }

    public static List<String> getMenuName() {
        return menuName;
    }

    public static List<Integer> getMenuQuantity() {
        return menuQuantity;
    }
}