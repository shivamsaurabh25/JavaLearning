import java.util.Scanner;
class factor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i = 1;
        System.out.print("Enter a number to find its factors: ");
        n = sc.nextInt();
        System.out.println("Factors of " + n + " are:");
        do {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
            i++;
        } while (i <= n);
        sc.close();
    }
}