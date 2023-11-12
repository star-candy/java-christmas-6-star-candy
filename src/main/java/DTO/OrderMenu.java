package DTO;

import java.util.ArrayList;
import java.util.List;

public class OrderMenu {
    private final List<OrderItem> orderItems; //record에서 list로 제공한 항목 저장

    public OrderMenu(List<OrderItem> orderItems) {
        this.orderItems = orderItems; //final 키워드로 인해 생성자에서 초기화 후 값 변경 x
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public record OrderItem(String menuName, int quantity) {
    }
}