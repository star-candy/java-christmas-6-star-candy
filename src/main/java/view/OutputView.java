package view;

import constants.Description;
import java.util.List;


public class OutputView {
    public static void discountDetails(List<String> discountName, List<Integer> discountQuantity) {
        System.out.println("<혜택 내역>");

        for (int index = 0; index < discountName.size(); index++) {
            System.out.printf(Description.DISCOUNT_DETAIL.getMessage(), discountName.get(index),
                    discountQuantity.get(index));
        }
    }

    public void printOrder(List<String> menuName, List<Integer> menuQuantity) {
        System.out.println("<주문 메뉴>");
        for (int index = 0; index < menuName.size(); index++) {
            System.out.printf(Description.ORDER_MENU_DETAIL.getMessage(), menuName.get(index), menuQuantity.get(index));
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