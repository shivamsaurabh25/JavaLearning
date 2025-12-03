import java.util.Scanner;
class convertCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c[] = new char[100];
        String st;
        System.out.print("Enter a string: ");
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                c[i] = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                c[i] = Character.toUpperCase(ch);
            }
        }
        st = new String(c);
        System.out.println("Converted String: " + st);
    }
}