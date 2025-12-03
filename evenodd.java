import java.util.Scanner;
class evenodd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i = 1, ec = 0, oc = 0;
        System.out.println("Enter a number: ");
        n = sc.nextInt();
        do {
            if(i % 2 == 0)
                ec++;
            else
                oc++;
            i++;
        } while (i <= n);
        System.out.println("Total even numbers: " + ec);
        System.out.println("Total odd numbers: " + oc);
        sc.close();
    }
}