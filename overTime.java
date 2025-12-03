import java.util.Scanner;
class overTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalOvertimePay = 0, employee = 1, hours, overtimeHours, overtimePay;
        do {
            System.out.print("Enter working hours of employee " + employee + ": ");
            hours = sc.nextInt();
            if (hours > 40) {
                overtimeHours = hours - 40;
                overtimePay = overtimeHours * 10;
                totalOvertimePay += overtimePay;
            }
            employee++;
        } while (employee <= 10);
        System.out.println("Total overtime paid by the organization is: Rs. " + totalOvertimePay);
        sc.close();
    }
}
