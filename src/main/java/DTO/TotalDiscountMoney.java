package DTO;

public class TotalDiscountMoney {
    private static int totalDiscountMoney;

    public static void setTotalDiscountMoney(int value) {
        totalDiscountMoney = value;
    }

    public static int getTotalDiscountMoney() {
        return totalDiscountMoney;
    }
}