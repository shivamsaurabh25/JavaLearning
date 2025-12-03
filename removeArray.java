import java.util.Scanner;
class removeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num[] = new int[10];
        int i, rp;
        System.out.println("Enter 10 numbers: ");
        for (i = 0; i < 10; i++) {
            num[i] = sc.nextInt();
        }
        System.out.print("Enter position to remove element: ");
        rp = sc.nextInt();
        for(i = rp - 1; i < 10; i++){
            if(i < 9) {
                num[i] = num[i + 1];
            } else {
                num[i] = 0;
            }
        }
        System.out.println("New array after removal of element: ");
        for(i = 0; i < 9; i++){
            System.out.print(num[i] + " ");
        }
        sc.close();
    }
}