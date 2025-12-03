import java.util.Scanner;
class primeFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i = 2;
        System.out.print("Enter a number: ");
        n = sc.nextInt();
        System.out.print("Prime factors of " + n + " are: ");
        while (n > 1) {
            if (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            } else {
                i++;
            }
        }
        sc.close();
    }
}