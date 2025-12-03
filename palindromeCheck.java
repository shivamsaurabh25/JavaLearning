import java.util.Scanner;
class palindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int i, c = 1 , l;
        System.out.println("Enter a String: ");
        str = sc.next();
        l = str.length();
        for(i = 0; i < l/2 ; i++) {
            if (str.charAt(i) != str.charAt(l - i - 1)){
                c = 0;
                break;
            }
        }
        if(c == 1){
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }
        sc.close();
    }
}
