import java.util.Scanner;
class sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i = 1, es = 0, os = 0;
        System.out.println("Enter 10 numbers: ");
        do {
            n = sc.nextInt();
            i++;
            if (i % 2 == 0) {
                es += n;
            } else {
                os += n;
            }
        } while (i <= 10);
        System.out.println("Sum of even placed numbers: " + es);
        System.out.println("Sum of odd placed numbers: " + os);
        sc.close();
    }
}