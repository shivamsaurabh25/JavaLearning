import java.util.Scanner;
class check{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n; String str;
        System.out.println("Enter a number: ");
        n = sc.nextInt();
        str = (n >= 1 && n <= 100) ? (n % 2 == 0) ? "Even" : "Odd" : "Unacceptable" ;
        System.out.println(str);
        sc.close();
    }
}