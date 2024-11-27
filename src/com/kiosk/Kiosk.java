package com.kiosk;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;     // 필드 캡슐화
    private Order order;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.order = new Order();
    }

    // Getter 메서드
    public List<Menu> getMenus() {
        return menus;
    }

    public Order getOrder() {
        return order;
    }

    // Kiosk 시작 메서드
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n===== 키오스크에 오신 것을 환영합니다 =====");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 주문 내역 확인 및 종료");

            System.out.print("카테고리를 선택하세요: ");
            try {
                int categoryChoice = Integer.parseInt(scanner.nextLine());

                if (categoryChoice == 0) {
                    order.displayOrder();
                    System.out.println("키오스크를 종료합니다. 이용해주셔서 감사합니다!");
                    isRunning = false;
                } else if (categoryChoice > 0 && categoryChoice <= menus.size()) {
                    Menu selectedMenu = menus.get(categoryChoice - 1);
                    handleMenuSelection(selectedMenu, scanner);
                } else {
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
        scanner.close();
    }

    // 메뉴 선택 처리 메서드
    private void handleMenuSelection(Menu menu, Scanner scanner) {
        boolean isMenuRunning = true;

        while (isMenuRunning) {
            menu.displayMenu();
            System.out.println("0. 돌아가기");

            System.out.print("메뉴 항목을 선택하세요: ");
            try {
                int menuItemChoice = Integer.parseInt(scanner.nextLine());

                if (menuItemChoice == 0) {
                    isMenuRunning = false;
                } else if (menuItemChoice > 0 && menuItemChoice <= menu.getMenuItems().size()) {
                    MenuItem selectedItem = menu.getMenuItem(menuItemChoice - 1);
                    System.out.println("주문에 추가된 항목: " + selectedItem.getName());
                    order.addOrderItem(selectedItem);
                } else {
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}
