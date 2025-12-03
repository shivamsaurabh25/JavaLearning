import java.util.Scanner;
class name {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fullName;
        int i;
        System.out.print("Enter full name: ");
        fullName = sc.nextLine().trim();
        String[] parts = fullName.split(" ");
        StringBuffer sb = new StringBuffer();
        for (i = 0; i < parts.length - 1; i++) {
            sb.append(parts[i].charAt(0)).append(".");
        }
        sb.append(parts[parts.length - 1]);
        System.out.println("Formatted Name: " + sb.toString());
        sc.close();
    }
}
