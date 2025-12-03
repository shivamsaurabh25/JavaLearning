import java.util.Scanner;
class uCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch; String str;
        System.out.print ("Enter a chracter: ");
        ch = sc.next().charAt(0);
        if(Character.isUpperCase(ch))
            str = "Upper";
        else if(Character.isLowerCase(ch))
            str = "Lower";
        else if(Character.isDigit(ch))
            str = "Digit";
        else
            str = "Symbol";
        System.out.println(str);
    }    
}