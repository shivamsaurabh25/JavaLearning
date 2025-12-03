import java.util.Scanner;
class armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, originalNum, sum = 0, count = 0, temp, digit, power, i;
        System.out.print("Enter a number: ");
        num = sc.nextInt();
        originalNum = num;
        temp = num;
        do {
            temp /= 10;
            count++;
        } while (temp != 0);
        temp = num;
        do {
            digit = temp % 10;
            power = 1;
            i = 1;
            do {
                power *= digit;
                i++;
            } while (i <= count);
            sum += power;
            temp /= 10;
        } while (temp != 0);
        if (sum == originalNum) {
            System.out.println(originalNum + " is an Armstrong number.");
        } else {
            System.out.println(originalNum + " is not an Armstrong number.");
        }
        sc.close();
    }
}