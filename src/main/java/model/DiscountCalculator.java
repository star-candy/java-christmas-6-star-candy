package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscountCalculator {
    private final List<String> discountName = new ArrayList<>();
    private final List<Integer> discountPayments = new ArrayList<>();
    private final int reservedDate;
    private final int giftReward;
    private final List<String> menuName;
    private final List<Integer> menuQuantity;

    private int totalDiscount;
    private String badgeName;

    public DiscountCalculator(int reservedDate, int giftReward, List<String> menuName, List<Integer> menuQuantity) {
        this.reservedDate = reservedDate;
        this.giftReward = giftReward;
        this.menuName = menuName;
        this.menuQuantity = menuQuantity;
        dDayDiscount();
        weekDayEndValidate();
        giftRewardDiscount();
        eventBadgeDiscount();
    }


    public void dDayDiscount() {//int return 전에 totalDiscount에 값 추가하기
        discountName.add("크리스마스 디데이 할인");
        int dDayStart = 1000;
        if (reservedDate > 25) {

            discountPayments.add(0);
        }
        for (int day = 1; day < reservedDate; day++) {
            dDayStart += 100;
        }
        totalDiscount += dDayStart;
        discountPayments.add(dDayStart);
        //return dDayStart;
    }

    public void weekDayEndValidate() {//int return 전에 totalDiscount에 값 추가하기
        final List<Integer> weekEnd = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
        if (weekEnd.contains(reservedDate)) {
            discountName.add("주말 할인");
            weekDiscount(true);
        }
        discountName.add("평일 할인");
        weekDiscount(false);
    }

    private void weekDiscount(boolean weekend) {
        final List<String> discountMenu;
        if (weekend) {
            discountMenu = Arrays.asList("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타");
        } else {
            discountMenu = Arrays.asList("초코케이크", "아이스크림");
        }

        int discountPayment = menuName.stream()
                .filter(currentMenu -> discountMenu.stream().anyMatch(currentMenu::contains))
                .mapToInt(menuName::indexOf)
                .mapToObj(index -> menuQuantity.get(index) * 2023)
                .reduce(0, Integer::sum);

        totalDiscount += discountPayment;
        discountPayments.add(discountPayment);
    }

    public void giftRewardDiscount() {
        discountName.add("증정 이벤트");
        int discountPayment = 0;
        if (giftReward > 0) {
            discountPayment = 25000;
        }
        totalDiscount += discountPayment;
        discountPayments.add(discountPayment);
        //return discountPayment;
    }

    public void eventBadgeDiscount() {
        discountName.add("특별 할인");
        int badgeDiscount = 0;
        badgeName = "없음";

        if (totalDiscount >= 20000) {
            badgeName = "산타";
        }

        if (totalDiscount >= 10000 && badgeName.equals("없음")) {
            badgeName = "트리";
        }

        if (totalDiscount >= 5000 && badgeName.equals("없음")) {
            badgeName = "별";
        }

        if (!badgeName.equals("없음")) {
            badgeDiscount = 1000;
            totalDiscount += badgeDiscount;
        }

        discountPayments.add(badgeDiscount);
    }

    public List<String> getDiscountName() {
        return discountName;
    }

    public List<Integer> getDiscountPayments() {
        return discountPayments;
    }

    public String getBadgeName() {
        return badgeName;
    }
    public int getTotalDiscount() {
        return totalDiscount;
    }
}
