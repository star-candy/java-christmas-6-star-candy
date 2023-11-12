package DTO;

import java.util.List;

public class DiscountDetails {//생성자를 private로 명시해서 값 변경 위험 줄이기
    private static List<String> discountName;
    private static List<Integer> discountQuantity;

    public static void initializeDiscountDetails(List<String> names, List<Integer> quantities) {
        discountName = names;
        discountQuantity = quantities;
    }

    public static List<String> getDiscountName() {
        return discountName;
    }

    public static List<Integer> getDiscountQuantity() {
        return discountQuantity;
    }
}