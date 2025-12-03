import java.util.Scanner;
class week {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weekDayNo; String weekDayName = "";
        System.out.println("Enter week day number(1-7)");
        weekDayNo = sc.nextInt();
        if (weekDayNo == 1) {
            weekDayName = "Monday";
        } else if(weekDayNo == 2) {
            weekDayName = "Tuesday";
        } else if(weekDayNo == 3) {
            weekDayName = "Wednesday";
        } else if(weekDayNo == 4) {
            weekDayName = "Thursady";
        } else if(weekDayNo == 5) {
            weekDayName = "Friday";
        } else if(weekDayNo == 6) {
            weekDayName = "Saturday";
        } else if(weekDayNo == 7) {
            weekDayName = "Sunday";
        } else {
            System.out.println("Wrong week day number inputted");
            sc.close();
            return;
        }
        System.out.println("Week day name is: " + weekDayName);
        sc.close();
    }
}
