import java.util.Scanner;
class duplicateRemove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, result = "";
        char ch;
        int i;
        System.out.print("Enter a string: ");
        str = sc.next();
        for (i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (result.indexOf(ch) == -1) {
                result += ch;
            }
        }
        System.out.println("String after removing duplicates: " + result);
        sc.close();
    }
}
