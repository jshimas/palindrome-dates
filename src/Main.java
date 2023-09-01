import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        int startYear = 2010;
        int endYear = 2015;

        List<String> palindromeDates = findPalindromeDates(startYear, endYear);

        if (!palindromeDates.isEmpty()) {
            System.out.println("Palindrome dates between " + startYear + " and " + endYear + ":");
            for (String date : palindromeDates) {
                System.out.println(date);
            }
        } else {
            System.out.println("No palindrome dates found between " + startYear + " and " + endYear);
        }
    }

    public static List<String> findPalindromeDates(int startYear, int endYear) throws ParseException {
        List<String> palindromeDates = new ArrayList<>();
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int year = startYear; year <= endYear; year++) {
            for (int month = 1; month <= 12; month++) {
                int maxDay = getDaysCountOfMonth(month, year);
                for (int day = 1; day <= maxDay; day++) {
                    String dateStr = String.format("%04d%02d%02d", year, month, day);

                    if (isPalindrome(dateStr)) {
                        String formattedDate = outputDateFormat.format(inputDateFormat.parse(dateStr));
                        palindromeDates.add(formattedDate);
                    }
                }
            }
        }

        return palindromeDates;
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
