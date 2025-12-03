import java.util.Scanner;
class removeDuplicateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num[] = new int[10];
        int i, j, k = 0;
        boolean isDuplicate;
        System.out.println("Enter 10 numbers: ");
        for (i = 0; i < 10; i++) {
            num[i] = sc.nextInt();
        }
        for (i = 0; i < 10; i++) {
            isDuplicate = false;
            for (j = 0; j < k; j++) {
                if (num[i] == num[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                num[k++] = num[i];
            }
        }
        System.out.println("Array after removing duplicates: ");
        for (i = 0; i < k; i++) {
            System.out.print(num[i] + " ");
        }
        sc.close();
    }
}