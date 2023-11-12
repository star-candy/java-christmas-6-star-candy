package DTO;

public class ReservedDate {
    private static int reservedDate;

    // 정적 메서드로 생성자 대체
    public static void initializeReservedDate(int date) {
        reservedDate = date;
    }

    public static int getReservedDate() {
        return reservedDate;
    }
}