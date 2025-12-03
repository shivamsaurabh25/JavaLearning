import java.util.Scanner;
class caseSeparate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        StringBuffer upper = new StringBuffer();
        StringBuffer lower = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch)) {
                upper.append(ch);
            } else if (Character.isLowerCase(ch)) {
                lower.append(ch);
            }
        }
        System.out.println("Uppercase letters: " + upper.toString());
        System.out.println("Lowercase letters: " + lower.toString());
        sc.close();
    }
}