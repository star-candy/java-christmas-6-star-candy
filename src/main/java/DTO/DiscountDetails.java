package DTO;

import java.util.List;

public class DiscountDetails {
    private final List<String> discountName;
    private final List<Integer> discountQuantity;

    public DiscountDetails(List<String> discountName, List<Integer> discountQuantity) {
        this.discountName = discountName;
        this.discountQuantity = discountQuantity;
    }

    public List<String> getDiscountName() {
        return discountName;
    }

    public List<Integer> getDiscountQuantity() {
        return discountQuantity;
    }

}
