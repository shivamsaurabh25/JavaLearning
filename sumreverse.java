import java.util.Scanner;
class sumreverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* int num, temp, sum = 0, reverse = 0, digit;
        System.out.print("Enter any number: ");
        num = sc.nextInt();
        temp = num;
        do {
            digit = num % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            num = num / 10;
        } while (num != 0);
        System.out.println("Sum of digits of " + temp + " is: " + sum);
        System.out.println("Reverse of " + temp + " is: " + reverse); */
        int num, r = 0, s = 0, d;
        System.out.println("Enter a 3-digit number: ");
        num = sc.nextInt();
        d = num % 10;
        num = num / 10;
        s = s + d;
        r = r * 10 + d;
        d = num % 10;
        num = num / 10;
        s = s + d + num;
        r = r * 10 + d;
        r = r * 10 + num;
        System.out.println("Sum = " + s);
        System.out.println("Reverse = " + r);
        sc.close();
    }
}