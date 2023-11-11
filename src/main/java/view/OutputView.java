package view;

import DTO.OrderMenu;
import DTO.OrderMenu.OrderItem;
import constants.Description;
import java.util.List;


public class OutputView {
    public void startNotify() {
        System.out.println(Description.ORDER_START.getMessage());
    }

    public void endNotify() {
        System.out.println(Description.ORDER_END.getMessage());
    }

    public static void printOrder(List<OrderMenu.OrderItem> orderItems) {
        System.out.println("<주문 메뉴>");
        for (OrderItem item : orderItems) {
            System.out.printf(Description.ORDER_MENU_DETAIL.getMessage(), item.menuName(), item.quantity());
        }
    }
}