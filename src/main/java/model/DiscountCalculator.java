package model;

import DTO.DiscountDetails;
import DTO.EventBadge;
import DTO.TotalDiscountMoney;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscountCalculator {
    private final List<String> discountName = new ArrayList<>();
    private final List<Integer> discountPayment = new ArrayList<>();
    private final int reservedDate;
    private final int giftReward;
    private final List<String> menuName;
    private final List<Integer> menuQuantity;


    TotalDiscountMoney totalDiscountMoney;
    private int totalDiscount;

    public DiscountCalculator(int reservedDate, int giftReward, List<String> menuName, List<Integer> menuQuantity) {
        this.reservedDate = reservedDate;
        this.giftReward = giftReward;
        this.menuName = menuName;
        this.menuQuantity = menuQuantity;
        discountCalculate();
    }

    private void discountCalculate() {
        discountPayment.add(dDayDiscount());
        discountPayment.add(weekDayEndValidate());
        discountPayment.add(giftRewardDiscount());
        discountPayment.add(eventBadgeDiscount());
        DiscountDetails.initializeDiscountDetails(discountName, discountPayment);
        totalDiscountMoney = new TotalDiscountMoney(totalDiscount);

    }

    private int dDayDiscount() {//int return 전에 totalDiscount에 값 추가하기
        discountName.add("크리스마스 디데이 할인");
        int dDayStart = 1000;
        if (reservedDate > 25) {
            return 0;
        }
        for (int day = 1; day < reservedDate; day++) {
            dDayStart += 100;
        }
        totalDiscount += dDayStart;
        return dDayStart;
    }

    private int weekDayEndValidate() {//int return 전에 totalDiscount에 값 추가하기
        final List<Integer> weekEnd = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
        if (weekEnd.contains(reservedDate)) {
            discountName.add("주말 할인");
            return weekDiscount(true);
        }
        discountName.add("평일 할인");
        return weekDiscount(false);
    }

    private int weekDiscount(boolean weekend) {
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
        return discountPayment;
    }

    private int giftRewardDiscount() {
        discountName.add("증정 이벤트");
        int discountPayment = 0;
        if (giftReward > 0) {
            discountPayment = 25000;
        }
        totalDiscount += discountPayment;
        return discountPayment;
    }

    private int eventBadgeDiscount() {
        discountName.add("특별 할인");
        int badgeDiscount = 0;
        String badge = "없음";

        if (totalDiscount >= 20000) {
            badge = "산타";
        }

        if (totalDiscount >= 10000 && badge.equals("없음")) {
            badge = "트리";
        }

        if (totalDiscount >= 5000 && badge.equals("없음")) {
            badge = "별";
        }

        if (!badge.equals("없음")) {
            badgeDiscount = 1000;
            totalDiscount += badgeDiscount;
        }

        EventBadge.setEventBadge(badge);
        return badgeDiscount;
    }
}
