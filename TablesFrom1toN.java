import java.util.Scanner;
class TablesFrom1toN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i = 1, j;
        System.out.print("Enter a number: ");
        n = sc.nextInt();
        while (i <= n) {
            System.out.println("Table of " + i + ":");
            j = 1;
            while (j <= 10) {
                System.out.println(i + " x " + j + " = " + (i * j));
                j++;
            }
            System.out.println();
            i++;
        }
        sc.close();
    }
}