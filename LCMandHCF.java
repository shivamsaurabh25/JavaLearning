import java.util.Scanner;
class LCMandHCF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, a, b, hcf, lcm;
        System.out.print("Enter first number: ");
        num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        num2 = sc.nextInt();
        a = num1;
        b = num2;
        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }
        hcf = num1;
        lcm = (a * b) / hcf;
        System.out.println("HCF = " + hcf);
        System.out.println("LCM = " + lcm);
        sc.close();
    }
}