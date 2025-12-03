import java.util.Scanner;
class minmax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[3][3];
        int i, j, min, max, posmini = 0, posminj = 0, posmaxi = 0, posmaxj = 0;
        System.out.println("Enter the elements of the 3x3 matrix:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        min = arr[0][0];
        max = arr[0][0];
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    posmini = i;
                    posminj = j;

                }
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    posmaxi = i;
                    posmaxj = j;
                }
            }
        }
        System.out.println("Minimum element: " + min + " and its position is: (" + posmini + "," + posminj + ")");
        System.out.println("Maximum element: " + max + " and its position is: (" + posmaxi + "," + posmaxj + ")");
        sc.close();
    }
}