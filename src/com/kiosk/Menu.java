package com.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName;    // 필드 캡슐화
    private List<MenuItem> menuItems;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    // Getter 메서드
    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // Setter 메서드
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // 메뉴 항목 추가 메서드
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    // 특정 메뉴 항목 반환 메서드
    public MenuItem getMenuItem(int index) {
        if (index >= 0 && index < menuItems.size()) {
            return menuItems.get(index);
        }
        return null;
    }

    // 메뉴 출력 메서드
    public void displayMenu() {
        System.out.println("===== " + categoryName + " Menu =====");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
    }
}
