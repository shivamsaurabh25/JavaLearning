import java.util.Scanner;
class table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i = 1;
        System.out.print("Enter the number whose table you want: ");
        n = sc.nextInt();
        System.out.println("Table of " + n + "is: ");
        do {
            System.out.println(n + " * " + i + " = " + n * i);
            i++;
        } while (i <= 10);
        sc.close();
    }
}