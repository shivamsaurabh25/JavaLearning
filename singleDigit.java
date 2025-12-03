import java.util.Scanner;
class singleDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, orgNum, sum = 0;
        System.out.println("Enter a number: ");
        n = sc.nextInt();
        orgNum = n;
        while (n >= 10) {
            sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        System.out.println("Single digit value of " + orgNum + " is: " + n); // 551 5+5+1=11=1+1=2
        sc.close();
    }
}