import java.util.Scanner;
class consonantVowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] v = new char[100];
        char[] c = new char[100];
        int vi = 0, ci = 0;
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                char lowerCh = Character.toLowerCase(ch);
                if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || 1lowerCh == 'o' || lowerCh == 'u') {
                    v[vi++] = ch;
                } else {
                    c[ci++] = ch;
                }
            }
        }
        String vowel = new String(v);
        String consonant = new String(c);
        System.out.println("Vowel String: " + vowel);
        System.out.println("Consonant String: " + consonant);
        sc.close();
    }
}