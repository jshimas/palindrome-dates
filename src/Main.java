import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        int startYear = 2010;
        int endYear = 2015;

        printBonusDatesBetween(startYear, endYear);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) throws ParseException {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int year = fromYear; year <= toYear; year++) {
            for (int month = 1; month <= 12; month++) {
                int maxDay = getDaysCountOfMonth(month, year);
                for (int day = 1; day <= maxDay; day++) {
                    String dateStr = String.format("%04d%02d%02d", year, month, day);

                    if (isPalindrome(dateStr)) {
                        System.out.println(outputDateFormat.format(inputDateFormat.parse(dateStr)));
                    }
                }
            }
        }
    }

    public static boolean isPalindrome(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    public static int getDaysCountOfMonth(int month, int year) {
        return switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 31;
        };
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
