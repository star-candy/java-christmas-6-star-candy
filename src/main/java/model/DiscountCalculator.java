package model;

import constants.Description;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscountCalculator {
    private final static int ZERO_COUNT = 0;
    private final static int FIRST_INDEX = 0;
    private final static int DAY_DISCOUNT_START = 1000;
    private final static int BADGE_DISCOUNT = 1000;
    private final static int DAY_DISCOUNT_FIRST_DAY = 25;
    private final static int DAY_DISCOUNT_LAST_DAY = 25;
    private final static int GIFT_PAYMENT = 25000;
    private final static int WEEK_DISCOUNT = 2023;
    private final static int THIRD_BADGE_POINT = 5000;
    private final static int SECOND_BADGE_POINT = 10000;
    private final static int FIRST_BADGE_POINT = 20000;
    private final static Integer[] WEEKEND = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30};

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
        int dDayStart = DAY_DISCOUNT_START;
        if (reservedDate > DAY_DISCOUNT_LAST_DAY) {
            discountPayments.add(FIRST_INDEX);
        }
        for (int day = DAY_DISCOUNT_FIRST_DAY; day < reservedDate; day++) {
            dDayStart += 100;
        }
        totalDiscount += dDayStart;
        discountPayments.add(dDayStart);
    }

    public void weekDayEndValidate() {
        final List<Integer> weekEnd = Arrays.asList(WEEKEND);
        if (weekEnd.contains(reservedDate)) {
            discountName.add("주말 할인");
            weekDiscount(true);
        }
        if (!weekEnd.contains(reservedDate)) {
            discountName.add("평일 할인");
            weekDiscount(false);
        }
    }

    private void weekDiscount(boolean weekend) {
        List<String> discountMenu = null;
        if (weekend) {
            discountMenu = Arrays.asList("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타");
        }
        if (!weekend) {
            discountMenu = Arrays.asList("초코케이크", "아이스크림");
        }

        List<String> finalDiscountMenu = discountMenu;
        int discountPayment = menuName.stream()
                .filter(currentMenu -> finalDiscountMenu.stream().anyMatch(currentMenu::contains))
                .mapToInt(menuName::indexOf)
                .mapToObj(index -> menuQuantity.get(index) * WEEK_DISCOUNT)
                .reduce(ZERO_COUNT, Integer::sum);

        totalDiscount += discountPayment;
        discountPayments.add(discountPayment);
    }

    public void giftRewardDiscount() {
        discountName.add("증정 이벤트");
        int discountPayment = ZERO_COUNT;
        if (giftReward > ZERO_COUNT) {
            discountPayment = GIFT_PAYMENT;
        }
        totalDiscount += discountPayment;
        discountPayments.add(discountPayment);
    }

    public void eventBadgeDiscount() {
        discountName.add("특별 할인");
        int badgeDiscount = ZERO_COUNT;
        badgeName = "없음";

        if (totalDiscount >= FIRST_BADGE_POINT) {
            badgeName = Description.BADGE_1ST.getMessage();
        }

        if (totalDiscount >= SECOND_BADGE_POINT && badgeName.equals("없음")) {
            badgeName = Description.BADGE_2ND.getMessage();
        }

        if (totalDiscount >= THIRD_BADGE_POINT && badgeName.equals("없음")) {
            badgeName = Description.BADGE_3RD.getMessage();
        }

        if (!badgeName.equals("없음")) {
            badgeDiscount = BADGE_DISCOUNT;
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
