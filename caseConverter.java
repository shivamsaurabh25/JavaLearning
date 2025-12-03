import java.util.Scanner;
class caseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch, upper, lower;
        System.out.println("Enter any character: ");
        ch = sc.next().charAt(0);
        if(ch >= 'a' && ch <= 'z'){
            upper = (char)(ch - 32); 
            System.out.println("Converted to uppercase: " + upper);
        }else if(ch >= 'A' && ch <= 'Z'){
            lower = (char)(ch + 32); 
            System.out.println("Converted to lowercase: " + lower);
        } else{
            System.out.println("The entered character is not an alphabet");
        }
        sc.close();
    }
}
