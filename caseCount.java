import java.util.Scanner;
class caseCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lCount = 0, uCount = 0;
        System.out.print("Enter a string: ");
        String input = sc.next();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch)) {
                uCount++;
            } else if (Character.isLowerCase(ch)) {
                lCount++;
            }
        }
        System.out.println("Number of uppercase letter is: " + uCount);
        System.out.println("Number of lowercase letter is: " + lCount);
        sc.close();
    }
}