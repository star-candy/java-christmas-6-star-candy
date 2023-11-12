package DTO;

public class PreDiscountPayment {
    private static int preDiscountPayment;

    public static void initializePreDiscountPayment(int payment) {
        preDiscountPayment = payment;
    }

    public static int getPreDiscountPayment() {
        return preDiscountPayment;
    }
}