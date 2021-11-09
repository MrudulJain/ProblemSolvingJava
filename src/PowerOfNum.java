/*
Find power of a number [Math.pow() implementation] in O(logN)
    Fast Power Method :
        Example 1:
            Suppose we have to compute 3^10, we can break it down as follows:
            3^10 = (3 * 3) * (3 * 3) * (3 * 3) * (3 * 3) * (3 * 3)
            3^10 = 9 * 9 * 9 * 9 * 9
            3^10 = 9^5
            Similarly,
            9^5 = (81^2) * 9
            (81^2) * 9 = (6561^1) * 9
            Therefore,
            3^10 = (6561^1) * 9

        Example 2:
            1) 2^30 = 2^30
            2) 4^15 = (4^14) * 4
            3) (16^7) * 4 = (16^6) * 16 * 4
            4) (256^3) * 16 * 4 = (256^2) * 256 * 16 * 4
            5) (65,536^1) * 256 * 16 * 4
            6) 2^30 = 65,536 * 256 * 16 * 4

        Algo:
            while(power > 0) // as power will become = 1
                if (power % 2 == 0)
                    num = num*num
                    power = power/2
                else
                    power = power - 1
                    result = result * num
                    num = num * num
                    power = power/2

            result = result * num
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
        System.out.println("Enter your choice: \n1.Recursive code \n2.Iterative code \n3.Math.pow function \n4.Fast Power Method O(logN)");
        ch = scanner.nextInt();

        switch (ch)
        {
            case 1:
                int index = 1;
                result = recursive(num, exp, index);
                System.out.println(num + "^" +exp+ " = " +result);
                break;
            case  2:
                result = iterative(num, exp);
                System.out.println(num + "^" +exp+ " = " +result);
                break;
            case 3:
                double res = inbuiltFun(num, exp);
                System.out.println(num + "^" +exp+ " = " +res);
                break;
            case 4:
                result = fastPower(num, exp);
                System.out.println(num + "^" +exp+ " = " +result);
                break;
            default:
                System.out.println("Enter the correct option");
                break;
        }
    }

    public static int fastPower(int num, int exp) // O(log(base 2)N) because we halve exp every iteration
    {
        int result = 1;

        if(result == 0)
            return result;

        while (exp != 1 && exp > 0) // by the end of this loop exp will always be equal to 1
        {
            if(exp % 2 == 0)
            {
                num *= num;
                exp = exp/2;
            }

            else
            {
                exp = exp - 1;
                result = result * num;
                num *= num;
                exp = exp/2;
            }
        }

        result = result * num;
        return result;
    }

    public static int recursive(int num, int exp, int index) // index == 1
    {
        if (index == exp || exp < 1)
            return num;

        return num * recursive(num, exp, index+1);
    }

    public static int iterative(int num, int exp)
    {
        int result = 1;
        while (exp > 0) {
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
