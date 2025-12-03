import java.util.Scanner;
class complexNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double real1, real2, addreal, subreal, img1, img2, addimg, subimg;
        System.out.print("Enter real part of 1st number: ");
        real1 = sc.nextDouble();
        System.out.print("Enter imaginary part of 1st number: ");
        img1 = sc.nextDouble();
        System.out.print("Enter real part of 2nd number: ");
        real2 = sc.nextDouble();
        System.out.print("Enter imaginary part of 2nd number: ");
        img2 = sc.nextDouble();
        addreal = real1 + real2;
        addimg = img1 + img2;
        subreal = real1 - real2;
        subimg = img1 - img2;
        System.out.println("Addition result: (" + real1 + " + " + img1 + "i) + (" + real2 + " + " + img2 + "i) = (" + addreal + " + " + addimg + "i)");
        System.out.println("Subtraction result: (" + real1 + " + " + img1 + "i) - (" + real2 + " + " + img2 + "i) = (" + subreal + " + " + subimg + "i)");
        sc.close();
    }
}