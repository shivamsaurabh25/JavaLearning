import java.util.Scanner;
import java.time.LocalDate;
class TeachersDayCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Teacher's Name: ");
        String teacherName = sc.nextLine();
        System.out.print("Enter Your Name: ");
        String studentName = sc.nextLine();
        LocalDate today = LocalDate.now();
        System.out.println();
        System.out.println("╔════════════════════════════════╗");
        System.out.println("   🌸🌸   Happy Teacher's Day!   🌸🌸");
        System.out.println("╚════════════════════════════════╝");
        System.out.println();
        System.out.println("Dear " + teacherName + ",");
        System.out.println("Thank you for your wisdom and support.");
        System.out.println("You inspire us every day! 📚✨");
        System.out.println();
        System.out.println("With respect,");
        System.out.println(studentName);
        System.out.println();
        System.out.println("Date: " + today);
    }
}

















