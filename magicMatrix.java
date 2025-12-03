import java.util.Scanner;
class MagicMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mat[][] = new int[3][3];
        System.out.println("Enter 3x3 matrix elements:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int sum = mat[0][0] + mat[0][1] + mat[0][2];
        boolean isMagic = true;
        for (int i = 0; i < 3 && isMagic; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < 3; j++) {
                rowSum += mat[i][j];
                colSum += mat[j][i];
            }
            if (rowSum != sum || colSum != sum) {
                isMagic = false;
            }
        }
        int diag1 = mat[0][0] + mat[1][1] + mat[2][2];
        int diag2 = mat[0][2] + mat[1][1] + mat[2][0];
        if (diag1 != sum || diag2 != sum) {
            isMagic = false;
        }
        System.out.println("\nMatrix:");
        for (int row[] : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println("\nThe matrix is " + (isMagic ? "a Magic Matrix." : "NOT a Magic Matrix."));
        sc.close();
    }
}