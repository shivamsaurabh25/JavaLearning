import java.util.*;
class reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, d, s = 0, r = 0;
        System.out.println("Enter a 3-digit number: ");
        num = sc.nextInt();
        d = num % 10;
        num /= 10;
        s = s + d;
        r = r * 10 + d;
        d = num % 10;
        num /= 10;
        s = s + d + num;
        r = r * 10 + d;
        r = r * 10 + num;
        System.out.println(s + "\t" + r);
        sc.close();
    }
}
