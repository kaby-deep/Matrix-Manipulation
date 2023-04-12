import java.util.*;

public class matrix {
    public static Scanner sc = new Scanner(System.in);
    static int mat[][], adj[][], trans[][];
    static int row, col;
    static int det;

    int[][] enter() {
        System.out.print("\nEnter the no. of Rows to the Matrix: ");
        row = sc.nextInt();
        System.out.print("\nEnter the no. of Columns to the Matrix: ");
        col = sc.nextInt();
        mat = new int[row][col];
        System.out.println("\nEnter Elements to the Matrix\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter a number: ");
                mat[i][j] = sc.nextInt();
            }
        }
        return mat;
    }

    void determinant(int x[][], int a, int b) {
        int temp[][] = new int[a][2 * b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                temp[i][j] = x[i][j];
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = b, j2 = 0; j < (2 * b) && j2 < b; j++, j2++) {
                temp[i][j] = x[i][j2];
            }
        }

        /*
         * for(int i=0;i<a;i++)
         * {
         * for(int j=0;j<2*b;j++)
         * {
         * System.out.print(temp[i][j]+"\t");
         * }
         * System.out.println();
         * }
         * System.out.println("\n");
         */

        for (int i = 0; i < b; i++) {
            int prod = 1;
            for (int j = 0; j < a; j++) {
                prod *= temp[j][i + j];
                // System.out.println(temp[j][i+j]);
            }
            // System.out.println("---"+prod);
            det += prod;
        }

        System.out.println("\n");

        for (int i = b; i < (2 * b); i++) {
            int prod = 1;
            for (int j = 0; j < a; j++) {
                prod *= temp[j][i - j];
                // System.out.println(temp[j][i-j]);
            }
            // System.out.println("---"+prod);
            det -= prod;
        }
        System.out.println("The Determinant of the matrix is: " + det);
    }

    void transpose(int[][] mat1, int r1, int c1) {
        trans = new int[c1][r1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                trans[j][i] = mat[i][j];
            }
        }
        this.display(trans,c1, r1);
    }

    void display(int x[][], int a, int b) {
        System.out.print("\n");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void main(String args[]) {
        matrix ob1 = new matrix();
        ob1.enter();
        System.out.print("\nThe Elements of the matrix are.\n");
        ob1.display(mat, row, col);
        ob1.determinant(mat, row, col);
        System.out.println("\nThe Transpose of the matrix is:\n");
        ob1.transpose(mat,row,col);
        // ob1.display(trans,col,row);
    }

    public void addition(int[][] mat1, int r1, int c1, int[][] mat2, int r2, int c2) {
    }

    public void subtraction(int[][] mat1, int r1, int c1, int[][] mat2, int r2, int c2) {
    }

    public void multiplication(int[][] mat1, int r1, int c1, int[][] mat2, int r2, int c2) {
    }
}