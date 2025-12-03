import java.util.Scanner;
class duplicateFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[100];
        int n, i, j, count;
        System.out.print("Enter the number of elements in the array: ");
        n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        for (i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Duplicate elements and their frequencies:");
        for (i = 0; i < n; i++) {
            count = 1;
            if (arr[i] != -1) {
                for (j = i + 1; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        arr[j] = -1;
                    }
                }
                if (count > 1) {
                    System.out.println(arr[i] + " occurs " + count + " times");
                }
            }
        }
        sc.close();
    }
}