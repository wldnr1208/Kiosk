package com.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 버거 메뉴 생성
        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 5.5, "치즈가 추가된 버거"));
        burgerMenu.addMenuItem(new MenuItem("VeggieBurger", 5.0, "채식주의자를 위한 버거"));

        // 음료 메뉴 생성
        Menu drinkMenu = new Menu("Drinks");
        drinkMenu.addMenuItem(new MenuItem("Coke", 2.5, "시원한 콜라"));
        drinkMenu.addMenuItem(new MenuItem("Lemonade", 3.0, "상큼한 레모네이드"));

        // 메뉴 리스트 생성
        List<Menu> menus = new ArrayList<>();
        menus.add(burgerMenu);
        menus.add(drinkMenu);

        // Kiosk 시작
        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
