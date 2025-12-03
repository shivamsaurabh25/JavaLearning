/* Function to print name 
import java.util.*;
public class functions {
    public static void printMyName(String name) {
        System.out.println(name);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.next();
        printMyName(name);
        sc.close();
    }
} */

/* Function to input 2 numbers and then return their sum
import java.util.*;
public class functions {
    public static int calcsum(int a, int b){
        int sum = a + b;
        return (sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int a = sc.nextInt();
        System.out.println("Enter a number: ");
        int b = sc.nextInt();
        int summ = calcsum(a, b);
        System.out.println("Sum of " + a + " & " + b + " is: " + summ);
        sc.close();
    }
} */

/* Function to multiply 2 numbers and return the product
import java.util.*;
public class functions {
    public static int calcproduct(int a, int b){
        int product = a * b;
        return (product);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int a = sc.nextInt();
        System.out.println("Enter a number: ");
        int b = sc.nextInt();
        int prod = calcproduct(a, b);
        System.out.println("Product of " + a + " & " + b + " is: " + prod);
        sc.close();
    }
} */

/* Find factorial of a number
import java.util.*;
public class functions {
    public static int factorial(int a){
        if (a < 0) {
            System.out.println("Invalid Number");
            return 0;
        }
        int fact = 1;
        for (int i = a; i >= 1; i--) {
            fact *= i;
        }
        return (fact);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        System.out.println("Factorial of " + a + " is: " + factorial(a));
        sc.close();
    }
}*/

/* Enter 3 numbers from the user & make a function to print their average
import java.util.*;
public class functions {
    public static int calcaverage(int a, int b, int c){
        return ((a + b + c) / 3);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        System.out.print("Enter a number: ");
        int b = sc.nextInt();
        System.out.print("Enter a number: ");
        int c = sc.nextInt();
        System.out.println("Average of " + a + " , " + b + " & " + c + " is: " + calcaverage(a, b, c));
        sc.close();
    }
} */

/* Write a function to print the sum of all odd numbers from 1 to n
import java.util.*;
public class functions {
    public static int sumofodd(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return (sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number upto which you want sum of odd number");
        int n = sc.nextInt();
        System.out.println("Sum of odd numbers from 1 to " + n + " is: " + sumofodd(n));
        sc.close();
    }
} */

/* Write a function which takes in 2 numbers and returns the greater of those two
import java.util.*;
public class functions {
    public static void greater(int a, int b){
        if (a == b) {
            System.out.println("Both numbers are equal");
            return;
        } else {
            if (a > b) {
                System.out.println( a + " is greater than " + b);
                return;
            } else {
                System.out.println( b + " is greater than " + a);
                return;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        System.out.print("Enter a number: ");
        int b = sc.nextInt();
        greater(a, b);
        sc.close();
    }
} */

/* Write a function that takes in the radius as input and returns the circumference of a circle
import java.util.*;
public class functions {
    public static float calaccircumference(float radius){
        float circumference = 2 * 3.14f * radius;
        return (circumference);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of circle: ");
        float radius = sc.nextFloat();
        float circumference = calaccircumference(radius);
        System.out.println("Circumference of circle of radius " + radius + " is: " + circumference);
        sc.close();
    }
} */

/* Write a function that takes in age as input and returns if that person is eligible to vote or not. A person of age > 18 is eligible to vote
import java.util.*;
public class functions{
    public static void vote(int age){
        if(age < 18){
            System.out.println("You are under age. You can't cast your vote");
        } else {
            System.out.println("You are 18 or 18+. You can cast your vote");
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        vote(age);
        sc.close();
    }
} */

/* Write an infinite loop using do while condition
public class functions {
    public static void main(String[] args) {
        int a = 1;
        do {
            System.out.println("Shivam is the boss");
        } while (a == 1);
    }
} */

/* Write a program to enter the number till user wants and at the end it should display the count of positive, negative and zeros entered
import java.util.*;
public class functions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char x;
        int zeros = 0, pos = 0, neg = 0;
        do{
            System.out.print("Enter a number: ");
            int a = sc.nextInt();
            if(a == 0){
                zeros += 1;
            } else {
                if (a > 0) {
                    pos += 1;
                } else {
                    neg += 1;
                }
            }
            System.out.print("Do you want to input more number(y/n): ");
            x = sc.next().charAt(0);
        } while( x == 'y' || x == 'Y');
        System.out.println("Number of zeroes entered: " + zeros);
        System.out.println("Number of positive numbers entered: " + pos);
        System.out.println("Number of negative numbers entered: " + neg);
        sc.close();
    }
} */

/* Two */