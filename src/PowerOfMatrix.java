/*
    Program to print power of  matrix
    Conditions:
    - Matrix must be a square matrix (mxm) as we will have to keep multiplying it to itself
    - Code iteratively and recursively
 */

import java.util.Scanner;

public class PowerOfMatrix {
    public static void main(String[] args) {
        // Accepting the matrix
        int exp;
        int[][] result;
        int[][] matrix = acceptMatrix();
        System.out.println("Given Matrix is: ");
        printMatrix(matrix);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the exponent: ");
        exp = scanner.nextInt();

        System.out.println("Iterative Method");
        result = iter(matrix, exp);
        System.out.println("Resultant matrix: ");
        printMatrix(result);

        System.out.println("Recursive Method");
        result = recur(matrix, exp);
        System.out.println("Resultant matrix: ");
        printMatrix(result);

    }

    public static void printMatrix(int[][] matrix)
    {
        for (int i =0; i < matrix.length; i++)
        {
            System.out.printf("\n[");
            for (int j =0; j < matrix[0].length; j++)
            {
                if (j == matrix[0].length-1)
                    System.out.print(matrix[i][j] +"]");
                else
                    System.out.print(matrix[i][j] +", ");
            }
        }
        System.out.println("");
    }

    public static int[][] acceptMatrix()
    {
        int row, col;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number of rows & cols (row, col) in the matrix: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row != col || row <= 0) {
                System.out.println("Number of rows must +ve and be equal to number of columns");
                continue;
            }
            break;
        }

        int[][] matrix = new int[row][col];
        System.out.println("Enter the elements inside the matrix");
        for (int i =0; i < row; i++) {
            for (int j=0; j < col; j++) {
                System.out.println("Element (" +i+ "," +j+ ") :");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] iter(int[][]m, int exp)
    {
        int[][] result = createIdentityMatrix(m.length);

        while (exp > 0)
        {
            if (exp % 2 == 1)
                result = matmult(m, result);

            m = matmult(m, m);
            exp = exp/2;
        }
        return result;
    }

    private static int[][] recur(int[][] m, int exp)
    {
        if(exp == 0) {
            int[][] identityMatrix = createIdentityMatrix(m.length);
            return identityMatrix;
        }

        int [][] resultant = recur(m, exp/2);
        if(exp % 2 != 0)
            return matmult(matmult(resultant, resultant), m);
        else
            return matmult(resultant, resultant);
    }

    private static int[][] createIdentityMatrix(int rows)
    {
        int[][] result = new int[rows][rows];
        for (int i =0; i < rows; i ++)
        {
            result[i][i] = 1;
        }

        return result;
    }

    private static int[][] matmult(int[][]m1, int[][]m2)
    {
        int [][] result = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m2[0].length; j++)
                for (int k = 0; k < m1[0].length; k++) // m1[0].length = m2.length (c2 == r2)
                    result[i][j] += m1[i][k] * m2[k][j];

        return result;
    }
}
