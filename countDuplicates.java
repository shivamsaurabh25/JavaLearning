import java.util.Scanner;
class countDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, checked = "";
        char ch;
        int i, j, count;
        System.out.print("Enter a string: ");
        str = sc.next();
        for (i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (checked.indexOf(ch) == -1) {
                count = 0;
                for (j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == ch) {
                        count++;
                    }
                }
                System.out.println(ch + " - " + count);
                checked += ch;
            }
        }
        sc.close();
    }
}