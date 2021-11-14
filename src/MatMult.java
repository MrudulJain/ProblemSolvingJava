
/* Program to multiply 2 matrices */

import java.util.Scanner;

public class MatMult {
    public static void main(String[] args) {
        acceptInput();
    }

    public static void acceptInput() {
        int[][] m1, m2;
        int r1, c1, r2, c2;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter dimensions of first matrix (rows, cols): ");
            r1 = scanner.nextInt();
            c1 = scanner.nextInt();
            System.out.println("Enter dimensions of second matrix (rows, cols): ");
            r2 = scanner.nextInt();
            c2 = scanner.nextInt();
            if (c1 != r2)
                System.out.println("Please enter the correct dimensions");
        } while (c1 != r2);

        m1 = new int[r1][c1];
        m2 = new int[r2][c2];

        System.out.println("Enter elements of first matrix");
        for (int i=0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.println("Element (" +i+ "," +j+ ") :");
                m1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements of second matrix");
        for (int i=0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.println("Element (" +i+ "," +j+ ") :");
                m2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("First matrix is: ");
        printMatrix(m1);
        System.out.println("\nSecond matrix is: ");
        printMatrix(m2);
        matMult(m1, m2);
    }

    public static int[][] matMult(int[][] m1, int[][] m2)
    {
        int[][] resultant = new int[m1.length][m2[0].length];
        for (int i =0; i< m1.length; i++)
            for (int j =0; j < m2[0].length; j++)
                for (int k = 0; k < m1[0].length; k++)  // m1[0].len == number of cols in first matrix = no of rows in 2nd matrix
                    resultant[i][j] += m1[i][k] * m2[k][j];

        System.out.println("The multiplication of both matrices is: ");
        printMatrix(resultant);
        return resultant;
    }


    public static void printMatrix(int[][] matrix)
    {
        for (int i =0; i < matrix.length; i++)
        {
            System.out.print("\n[");
            for (int j =0; j < matrix[0].length; j++)
            {
                if (j == matrix[0].length-1)
                    System.out.print(matrix[i][j] +"]");
                else
                    System.out.print(matrix[i][j] +", ");
            }
        }
    }
}
