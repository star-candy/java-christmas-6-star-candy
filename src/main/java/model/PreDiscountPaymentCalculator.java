package model;

import constants.Description;
import constants.Menu;
import java.util.List;

public class PreDiscountPaymentCalculator {
    private final static int RESET = 0;

    private final List<String> menuName;
    private final List<Integer> menuQuantity;


    public PreDiscountPaymentCalculator(List<String> menuName, List<Integer> menuQuantity) {
        this.menuName = menuName;
        this.menuQuantity = menuQuantity;
    }

    public int preDiscountPaymentCalculate() {
        int totalPayment = RESET;

        try {
            for (int index = RESET; index < menuName.size(); index++) {
                String currentMenuName = menuName.get(index);
                int currentMenuQuantity = menuQuantity.get(index);

                // Menu 열거형에서 현재 메뉴 이름과 일치하는 항목 찾기
                Menu matchedMenu = findMenuByName(currentMenuName);

                if (matchedMenu != null) {
                    // 메뉴가 발견되면 해당 메뉴의 가격과 수량을 곱하여 총 결제액에 더함
                    totalPayment += (int) (matchedMenu.getPrice() * currentMenuQuantity);
                }
                if (matchedMenu == null) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Description.ERROR_NO_MENU.getMessage());
        }

        return totalPayment;
    }

    private Menu findMenuByName(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equalsIgnoreCase(menuName)) {
                return menu;
            }
        }
        return null;
    }
}
