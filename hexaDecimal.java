import java.util.Scanner;
class hexaDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dec, rem;
        String hex = "";
        System.out.print("Enter a decimal number: ");
        dec = sc.nextInt();
        if (dec == 0) {
            hex = "0";
        } else {
            while (dec > 0) {
                rem = dec % 16;
                if (rem < 10) {
                    hex = rem + hex;
                } else {
                    char ch = (char) ('A' + (rem - 10));
                    hex = ch + hex;
                }
                dec /= 16;
            }
        }
        System.out.println("Hexadecimal number is: " + hex);
        sc.close();
    }
}