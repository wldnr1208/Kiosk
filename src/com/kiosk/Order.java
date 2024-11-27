package com.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> orderItems;  // 필드 캡슐화

    public Order() {
        this.orderItems = new ArrayList<>();
    }

    // Getter 메서드
    public List<MenuItem> getOrderItems() {
        return orderItems;
    }

    // 주문 항목 추가 메서드
    public void addOrderItem(MenuItem menuItem) {
        orderItems.add(menuItem);
    }

    // 주문 내역 출력 메서드
    public void displayOrder() {
        System.out.println("===== Your Order =====");
        if (orderItems.isEmpty()) {
            System.out.println("No items in your order.");
        } else {
            double total = 0;
            for (MenuItem item : orderItems) {
                System.out.println(item);
                total += item.getPrice();
            }
            System.out.printf("Total: $%.2f\n", total);
        }
    }
}
