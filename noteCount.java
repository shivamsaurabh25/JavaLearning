import java.util.Scanner;
class noteCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount;
        System.out.println("Enter amount: ");
        amount = sc.nextInt();
        int five = amount / 500;
        amount %= 500;
        int two = amount / 200;
        amount %= 200;
        int hundred = amount / 100;
        amount %= 100;
        int fifty = amount / 50;
        System.out.println("500 Notes: " + five);
        System.out.println("200 Notes: " + two);
        System.out.println("100 Notes: " + hundred);
        System.out.println("50 Notes: " + fifty);
        sc.close();
    }
}