/*
Iterative and recursive code to find power of a number [Math.pow() implementation] in O(logN)
 */

import java.util.Scanner;

public class PowerOfNum {
    public static void main(String[] args) {
        int num, exp, ch, result;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number: ");
        num = scanner.nextInt();
        System.out.println("Enter the exponent: ");
        exp = scanner.nextInt();
        System.out.println("Enter your choice: \n1.Recursive code \n2.Iterative code \n3.Math.pow function:");
        ch = scanner.nextInt();

        switch (ch)
        {
            case 1:
                int index = 1;
                result = recursive(num, exp, index);
                System.out.println(num + " raised to the power " +exp+ " is: " +result);
                break;
            case  2:
                result = iterative(num, exp);
                System.out.println(num + " raised to the power " +exp+ " is: " +result);
                break;
            case 3:
                 double res = inbuiltFun(num, exp);
                System.out.println(num + " raised to the power " +exp+ " is: " +res);
                break;
            default:
                System.out.println("Enter the correct option");
                break;
        }
    }

    public static int recursive(int num, int exp, int index) // index == 1
    {
        if (index == exp)
            return num;

        return num * recursive(num, exp, index+1);
    }

    public static int iterative(int num, int exp)
    {
        int result = 1;
        while (exp != 0) {
            result *= num;
            --exp;
        }
        return result;
    }

    public static double inbuiltFun(int num, int exp)
    {
        return Math.pow((double) num, (double) exp);
    }
}
