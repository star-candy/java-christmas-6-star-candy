package DTO;

import java.util.ArrayList;
import java.util.List;
public class DiscountDetails {
    private final List<DiscountItem> discountItems;

    public DiscountDetails() {
        this.discountItems = new ArrayList<>();
    }

    public void addDiscountItems(String discountName, int amount) {
        discountItems.add(new DiscountItem(discountName, amount));
    }

    public List<DiscountItem> getDiscountItems() {
        return discountItems;
    }

    public record DiscountItem(String discountName, int amount) {
    }

}
