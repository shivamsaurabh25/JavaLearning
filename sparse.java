import java.util.Scanner;
class sparse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mat[][] = new int[3][3];
        int i, j, nonZeroCount = 0, zeroCount = 0;
        System.out.println("Enter the elements of the 3x3 matrix:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                mat[i][j] = sc.nextInt();
                if (mat[i][j] != 0) {
                    nonZeroCount++;
                }
            }
        }
        zeroCount = 9 - nonZeroCount;
        System.out.println("Matrix is:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        if (zeroCount > nonZeroCount) {
            System.out.println("The matrix is a Sparse Matrix.");
        } else {
            System.out.println("The matrix is NOT a Sparse Matrix.");
        }
        sc.close();
    }
}