import java.util.Scanner;
class searchCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        char s;
        int i, c = 0;
        System.out.print("Enter a string: ");
        str = sc.next();
        System.out.print("Enter a character to search: ");
        s = sc.next().charAt(0);
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == s) {
                c = 1;
                break;
            }
        }
        if (c == 1)
            System.out.println("The character " + s + " found in the string");
        else
            System.out.println("The character " + s + " not found in the string");
        sc.close();
    }
}
