package view;

import constants.Description;
import java.util.List;

public class OutputView {

    public void startNotify() {
        System.out.println(Description.ORDER_START.getMessage());
    }

    public void endNotify() {
        System.out.println(Description.ORDER_END.getMessage());
    }

    public void printOrder(List<String> menuName, List<Integer> menuQuantity) {
        System.out.println("<주문 메뉴>");
        for (int index = 0; index < menuName.size(); index++) {
            System.out.printf(Description.ORDER_MENU_DETAIL.getMessage(), menuName.get(index), menuQuantity.get(index));
        }
        System.out.println();
    }

    public void preDiscountPayment(int payment) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf(Description.PAYMENT.getMessage(), payment);
    }

    public void giftReward(int giftCount) {
        System.out.println("<증정 메뉴>");
        if (giftCount > 0) {
            System.out.printf(Description.GIFT_DETAIL.getMessage(), giftCount);
        } else {
            System.out.println("없음\n");
        }
    }

    public void discountDetails(List<String> discountName, List<Integer> discountQuantity) {
        System.out.println("<혜택 내역>");
        for (int index = 0; index < discountName.size(); index++) {
            System.out.printf(Description.DISCOUNT_DETAIL.getMessage(), discountName.get(index),
                    discountQuantity.get(index));
        }
        System.out.println();
    }

    public void totalDiscountPayment(int totalDiscountPayment) {
        System.out.println("<총혜택 금액>");
        System.out.printf(Description.PAYMENT.getMessage(), totalDiscountPayment);
    }

    public void totalPayment(int preDiscountPayment, int totalDiscountPayment, int giftCount) {
        System.out.println("<할인 후 예상 결제 금액>");
        int totalPayment = preDiscountPayment - totalDiscountPayment;
        if (giftCount == 1) {
            totalPayment -= 25000;
        }
        System.out.printf(Description.PAYMENT.getMessage(), totalPayment);
    }

    public void eventBadge(String eventBadge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(eventBadge);
    }

    public void noDiscountPrint(int payment) {
        System.out.println("<증정 메뉴>\n없음\n");
        System.out.printf("<혜택 내역>" + System.lineSeparator() + "없음\n");
        System.out.println("<총혜택 금액>\n0원\n");
        System.out.println("<할인 후 예상 결제 금액>\n" + payment + "원\n");
        System.out.println("<12월 이벤트 배지>\n없음\n");
    }
}