package view;

import DTO.DiscountDetails;
import DTO.DiscountDetails.DiscountItem;
import DTO.OrderMenu;
import DTO.OrderMenu.OrderItem;
import constants.Description;
import java.util.List;


public class OutputView {
    public static void printOrder(List<OrderMenu.OrderItem> orderItems) {
        System.out.println("<주문 메뉴>");
        for (OrderItem item : orderItems) {
            System.out.printf(Description.ORDER_MENU_DETAIL.getMessage(), item.menuName(), item.quantity());
        }
    }

    public static void discountDetails(List<DiscountDetails.DiscountItem> discountItems) {
        System.out.println("<혜택 내역>");
        for (DiscountItem item : discountItems) {
            System.out.printf(Description.DISCOUNT_DETAIL.getMessage(), item.discountName(), item.amount());
        }
    }

    public void startNotify() {
        System.out.println(Description.ORDER_START.getMessage());
    }

    public void endNotify() {
        System.out.println(Description.ORDER_END.getMessage());
    }

    public void preDiscountPayment(int payment) {
        System.out.println("<할인 전 총주문 금액");
        System.out.println(payment + "원");
    }

    public void giftReward(int giftCount) {
        System.out.printf(Description.GIFT_DETAIL.getMessage(), giftCount);
    }

    public void totalDiscountPayment(int totalDiscountPayment) {
        System.out.println("<총혜택 금액>");
        System.out.println(totalDiscountPayment + "원");
    }

    public void totalPayment(int preDiscountPayment, int totalDiscountPayment) {
        System.out.println("<할인 후 예상 결제 금액>");
        int totalPayment = preDiscountPayment - totalDiscountPayment;
        System.out.println(totalPayment + "원");
    }

    public void eventBadge(String eventBadge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(eventBadge);
    }
}