package constants;

public enum Description {
    ORDER_START("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    INPUT_DATE_NOTIFY("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDER_MENU_NOTIFY("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    ORDER_END("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_DETAIL("%s %d개"),
    DISCOUNT_DETAIL("%s: %d원"),
    GIFT_DETAIL("샴페인 %d개"),
    MAIN_MENU("티본스테이크, 바비큐립, 해산물파스타, 크리스마스파스타"),
    DESSERT("초코케이크, 아이스크림"),
    DRINK("제로콜라, 레드와인, 샴페인"),
    ERROR_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_NO_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_MENU_VALUE("[ERROR] 유효하지 않은 값 입니다. 다시 입력해 주세요."),
    ERROR_MENU_FORM("[ERROR] 유효하지 않은 형식입니다. 다시 입력해 주세요."),
    ERROR_MENU_DUPLICATE("[ERROR] 중복된 주문이 있습니다. 다시 입력해 주세요."),
    ERROR_ONLY_DRINK("[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요."),
    ERROR_MENU_FULL("[ERROR] 20개까지 주문할 수 있습니다. 다시 입력해 주세요."),

    BADGE_3RD("별"),
    BADGE_2ND("트리"),
    BADGE_1ST("산타");

    private final String message;

    Description(String message) {
        this.message = message;
    } //enum 타입에서 string 타입으로 변환

    public String getMessage() {
        return message;
    }
}

