package DTO;

import java.util.ArrayList;
import java.util.List;

public class OrderMenu {
    private final List<OrderItem> orderItems;

    public OrderMenu() {
        this.orderItems = new ArrayList<>();
    }

    public void addOrderItem(String menuName, int quantity) {
        orderItems.add(new OrderItem(menuName, quantity));
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public record OrderItem(String menuName, int quantity) {
    }
}