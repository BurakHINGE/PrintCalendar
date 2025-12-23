import java.util.Scanner;

public class tr_printCalendar {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Yılı giriniz: ");
        int year = input.nextInt();

        System.out.println("Ayı giriniz (1-12): ");
        int month = input.nextInt();

        printMonth(year, month);
    }

    public static void printMonth(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    public static String getMonthName(int month) {
        String monthName = "";

        switch (month) {
            case 1: monthName = "Ocak"; break;
            case 2: monthName = "Şubat"; break;
            case 3: monthName = "Mart"; break;
            case 4: monthName = "Nisan"; break;
            case 5: monthName = "Mayıs"; break;
            case 6: monthName = "Haziran"; break;
            case 7: monthName = "Temmuz"; break;
            case 8: monthName = "Ağustos"; break;
            case 9: monthName = "Eylül"; break;
            case 10: monthName = "Ekim"; break;
            case 11: monthName = "Kasım"; break;
            case 12: monthName = "Aralık"; break;
        }

        return monthName;
    }

    public static void printMonthTitle(int year, int month) {
        System.out.println("        " + getMonthName(month) + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Paz Pzt Sal Çar Per Cum Cts");
    }

    public static void printMonthBody(int year, int month) {

        int startDay = getStartDay(year, month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (int i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static int getStartDay(int year, int month) {
        final int START_DAY_FOR_JAN_1_1800 = 3;
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;

        for (int i = 1800; i < year; i++) {
            total += isLeapYear(i) ? 366 : 365;
        }

        for (int i = 1; i < month; i++) {
            total += getNumberOfDaysInMonth(year, i);
        }

        return total;
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
            month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        return 0;
    }
}
