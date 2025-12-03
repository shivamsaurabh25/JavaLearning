import java.util.Scanner;
class transpose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mat[][] = new int[3][3];
        int i, j;
        System.out.println("Enter the elements of the 3x3 matrix:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println("Transpose of the matrix:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(mat[j][i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}