import java.util.Scanner;
class toggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, st; char ch[] = new char[100];
        int i;
        System.out.print("Enter a string: ");
        str = sc.next();
        ch = str.toCharArray();
        for(i = 0; i < str.length(); i++){
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = Character.toLowerCase(ch[i]);
            } else if (ch[i] >= 'a' && ch[i] <= 'z') {
                ch[i] = Character.toUpperCase(ch[i]);
            }
        }
        st = new String(ch);
        System.out.println("Toggled case string: " + st);
        sc.close();
    }
}