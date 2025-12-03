import java.util.Scanner;
class AutomorphicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, square, temp, digits = 0, modulus = 1, i = 0;
        System.out.print("Enter a number: ");
        num = sc.nextInt();
        square = num * num;
        temp = num;
        System.out.println(square);
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        while (i < digits) {
            modulus *= 10;
            i++;
        }
        if (square % modulus == num) {
            System.out.println(num + " is an Automorphic Number."); // 5^2 = 25 -> jis number ka square kre wo square ke last digit me aana chahiye
        } else {
            System.out.println(num + " is NOT an Automorphic Number.");
        }
        sc.close();
    }
}