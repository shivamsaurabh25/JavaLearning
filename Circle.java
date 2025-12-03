import java.util.Scanner;
class Circle {
    public static void calcPerimeter(double radius){
        double p;
        p = 2 * 3.14 * radius;
        System.out.println("Perimeter of circle having radius " + radius + " is: " + p);
        calcArea(radius);
    }
    public static void calcArea(double radius){
        double ar;
        ar = 3.14 * radius * radius;
        System.out.println("Area of circle having radius " + radius + " is: " + ar);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r;
        System.out.print("Enter the radius: ");
        r = sc.nextDouble();
        calcPerimeter(r);
        sc.close();
    }    
}
