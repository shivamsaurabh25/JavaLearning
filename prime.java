import java.util.Scanner;
class prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, p = 0, i = 1, j, c;
        System.out.println("Enter 10 numbers");
        while (i <= 10) {
            n =sc.nextInt();
            j = 2;
            c = 0;
            if (n < 2) {
                c = 1;
            }else {
                while (j <= n / 2) {
                    if (n % j == 0) {
                        c = 1;
                        break;
                    }
                    j++;
                }
            }
            if (c == 0) {
                p++;
            }
            i++;
        }
        System.out.println("Number of prime numbers are: " + p);
        sc.close();
    }
}
