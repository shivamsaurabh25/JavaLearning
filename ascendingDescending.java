import java.util.Scanner;
class ascendingDescending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many numbers you want to sort: ");
        int n = sc.nextInt();
        int numbers[] = new int[n];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.println("Choose order:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((choice == 1 && numbers[j] > numbers[j + 1]) ||
                    (choice == 2 && numbers[j] < numbers[j + 1])) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        if (choice == 1) {
            System.out.println("Numbers in ascending order:");
        } else if (choice == 2) {
            System.out.println("Numbers in descending order:");
        } else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
        sc.close();
    }
}