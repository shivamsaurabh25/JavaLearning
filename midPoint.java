import java.util.Scanner;
class midPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x, x1, x2, y, y1, y2;
        System.out.print("Enter coordinate x1: ");
        x1 = sc.nextDouble();
        System.out.print("Enter coordinate y1: ");
        y1 = sc.nextDouble();
        System.out.print("Enter coordinate x2: ");
        x2 = sc.nextDouble();
        System.out.print("Enter coordinate y2: ");
        y2 = sc.nextDouble();
        x = (x1 + x2)/2;
        y = (y1 + y2)/2;
        System.out.println("Mid point coordinate of line having coordinates (" + x1 + ", " + y1 + ") & (" + x2 + ", " + y2 + ") is (" + x + ", " + y + ")");
        sc.close();
    }
}