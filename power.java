import java.util.Scanner;
class power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base, expo, power = 1, i = 1;
        System.out.print("Enter base value and exponent value: ");
        base = sc.nextInt();
        expo = sc.nextInt();
        do {
            power *= base;
            i++;
        } while (i <= expo);
        System.out.println(base + " raised to the power " + expo + " is :" + power);
        sc.close();
    }
}