import java.util.Scanner;
class ascii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0, count = 0;
        do {
            System.out.println("Character: " + (char)i + " | ASCII Value: " + i);
            count++;
            if (count % 20 == 0) {
                System.out.print("Press Enter to continue...");
                sc.nextLine();
            }
            i++;
        } while (i <= 255);
        sc.close();
    }
}