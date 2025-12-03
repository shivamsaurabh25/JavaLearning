import java.util.*;
class digitAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, d, o, t, newNum;
        System.out.println("Enter a 3-digit number: ");
        num = sc.nextInt();
        d = num % 10;
        o = d + 1;
        num /= 10;
        d = num % 10;
        t = d + 1;
        num /= 10;
        num += 1;
        newNum = num * 100 + t * 10 + o;
        System.out.println("New nummber is: " + newNum);
        sc.close();
    }    
}