import java.util.Scanner;
class twomatSumMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mat1[][] = new int[3][3];
        int mat2[][] = new int[3][3];
        int i, j, k;
        System.out.println("Enter the elements of the first 3x3 matrix:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the elements of the second 3x3 matrix:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }
        System.out.println("\nChoose an operation:");
        System.out.println("1. Sum of matrices");
        System.out.println("2. Multiplication of matrices");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Sum of the two matrices:");
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        int sumElement = mat1[i][j] + mat2[i][j];
                        System.out.print(sumElement + " ");
                    }
                    System.out.println();
                }
                break;
            case 2:
                int productMat[][] = new int[3][3];
                System.out.println("Product of the two matrices:");
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        productMat[i][j] = 0;
                        for (k = 0; k < 3; k++) {
                            productMat[i][j] += mat1[i][k] * mat2[k][j];
                        }
                        System.out.print(productMat[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }
}