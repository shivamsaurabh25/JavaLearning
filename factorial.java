import java.util.Scanner;
class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, factorial = 1, i = 1;
        System.out.print("Enter a number to find its factorial: ");
        n = sc.nextInt();
        do {
            factorial *= i;
            i++;
        } while (i <= n);
        System.out.println("Factorial of " + n + " is: " + factorial);
        sc.close();
    }
}