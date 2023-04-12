import java.util.*;

public class matrix1 {
    public static Scanner sc = new Scanner(System.in);
    static int mat1[][], mat2[][];
    static int row, col;
    static int det;

    int[][] enter() {
        System.out.print("\nEnter the no. of Rows to the Matrix: ");
        row = sc.nextInt();
        System.out.print("\nEnter the no. of Columns to the Matrix: ");
        col = sc.nextInt();
        int x[][] = new int[row][col];
        System.out.println("\nEnter Elements to the Matrix\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter a number: ");
                x[i][j] = sc.nextInt();
            }
        }
        return x;
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
        for (int i = 0; i < b; i++) {
            int prod = 1;
            for (int j = 0; j < a; j++) {
                prod *= temp[j][i + j];
            }
            det += prod;
        }

        System.out.println("\n");

        for (int i = b; i < (2 * b); i++) {
            int prod = 1;
            for (int j = 0; j < a; j++) {
                prod *= temp[j][i - j];
            }
            det -= prod;
        }
        System.out.println("The Determinant is: " + det);
    }

    void transpose(int x[][], int r, int c) {
        int trans[][] = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                trans[j][i] = x[i][j];
            }
        }
        System.out.println("\nThe Transpose of the matrix is:\n");
        display(trans, c, r);
    }

    void multiplication(int x[][], int r1, int c1, int y[][], int r2, int c2) {
        if (c1 != r2) {
            System.out.println("The Multiplication is not possible.\n");
            return;
        } else {
            int res[][] = new int[r1][c2];

            for (int i = 0; i < r1; i++) // calculating the product matrix
            {
                for (int j = 0; j < c2; j++) {
                    int sum = 0;
                    for (int k = 0; k < c1; k++) {
                        sum += (x[i][k] * y[k][j]);
                    }
                    res[i][j] = sum;
                }
            }

            System.out.println("\nThe Resulting Matrix is.");
            display(res, r1, c2);
        }

    }

    void addition(int x[][], int r1, int c1, int y[][], int r2, int c2) {
        if (c1 != c2 && r1 != r2) {
            System.out.println("The Addition is not possible.\n");
            return;
        } else {
            int res[][] = new int[r1][c2];

            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    res[i][j] = x[i][j] + y[i][j];
                }
            }

            System.out.println("\nThe Resulting Matrix is.");
            display(res, r1, c2);
        }
    }

    void subtraction(int x[][], int r1, int c1, int y[][], int r2, int c2) {
        if (c1 != c2 && r1 != r2) {
            System.out.println("The Subtraction is not possible.\n");
            return;
        } else {
            int res[][] = new int[r1][c2];

            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    res[i][j] = x[i][j] - y[i][j];
                }
            }

            System.out.println("\nThe Resulting Matrix is.");
            display(res, r1, c2);
        }
    }

    void display(int x[][], int r, int c) {
        System.out.print("\n");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void main(String args[]) {
        matrix1 ob1 = new matrix1();
        while (true) {
            System.out.println(
                    "\n\tMenu\t\n1.Addition of Two Matrices\n2.Subtraction of Two Matrices\n3.Multiplication of two matrices\n4.Transpose of a Matrix\n5.Determinant of a Matrix\n6.EXIT");
            System.out.println("Enter choice:");
            int choice = sc.nextInt();
            int r1, c1, r2, c2;
            switch (choice) {
                case 1:
                    mat1 = ob1.enter();
                    r1 = row;
                    c1 = col;
                    mat2 = ob1.enter();
                    r2 = row;
                    c2 = col;
                    ob1.addition(mat1, r1, c1, mat2, r2, c2);
                    break;

                case 2:
                    mat1 = ob1.enter();
                    r1 = row;
                    c1 = col;
                    mat2 = ob1.enter();
                    r2 = row;
                    c2 = col;
                    ob1.subtraction(mat1, r1, c1, mat2, r2, c2);
                    break;

                case 3:
                    mat1 = ob1.enter();
                    r1 = row;
                    c1 = col;
                    mat2 = ob1.enter();
                    r2 = row;
                    c2 = col;
                    ob1.multiplication(mat1, r1, c1, mat2, r2, c2);
                    break;

                case 4:
                    mat1 = ob1.enter();
                    r1 = row;
                    c1 = col;
                    ob1.transpose(mat1, r1, c1);
                    break;

                case 5:
                    mat1 = ob1.enter();
                    r1 = row;
                    c1 = col;
                    ob1.determinant(mat1, r1, c1);
                    break;

                case 6:
                    System.exit(0);
                    break;

            }
        }
    }
}