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
            {
                if (power % 2 == 0)
                    num = num*num
                    power = power/2
                else
                    power = power - 1
                    result = result * num
                    num = num * num
                    power = power/2
            }
            result = result * num
 */

import java.util.Scanner;

public class PowerOfNum {
    public static final int MOD = 1000000007;
    public static void main(String[] args) {
        int num, exp, ch, ch2, result;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number: ");
        num = scanner.nextInt();
        System.out.println("Enter the exponent: ");
        exp = scanner.nextInt();


        do {
            System.out.println("Enter your choice: \n1.Fast Power Method [O(logN)] \n2.Normal Method [O(n)] \n3.Exit");
            ch = scanner.nextInt();

            switch (ch)
            {
                case 1:
                    ch2 = 0;
                    while (ch2 != 4)
                    {
                        System.out.println("Enter your choice: \n1.Iterative Fast Power \n2.Recursive fast power \n3.Recursive Fast Power (with MOD for bigger numbers) \n4.Back to Previous Menu");
                        ch2 = scanner.nextInt();
                        switch (ch2)
                        {
                            case 1:
                                result = iterativeFastPower(num, exp);
                                System.out.println(num + "^" + exp + " = " + result);
                                break;
                            case 2:
                                result = recursiveFastPower(num, exp);
                                System.out.println(num + "^" + exp + " = " + result);
                                break;
                            case 3:
                                result = recursiveFastPowerMOD(num, exp);
                                System.out.println(num + "^" + exp + " = " + result);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Please enter the correct number");
                                break;
                        }
                    }
                    break;
                case 2:
                    ch2 = 0;
                    while (ch2 != 4) {
                        System.out.println("Enter your choice: \n1.Iterative \n2.Recursive \n3.Inbuilt (Math.pow) function \n4.Back to Previous Menu");
                        ch2 = scanner.nextInt();
                        switch (ch2) {
                            case 1:
                                result = iterative(num, exp);
                                System.out.println(num + "^" + exp + " = " + result);
                                break;
                            case 2:
                                result = recursive(num, exp);
                                System.out.println(num + "^" + exp + " = " + result);
                                break;
                            case 3:
                                double temp = Math.pow(num, exp);
                                System.out.println(num + "^" + exp + " = " + temp);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Please enter the correct number");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Enter the correct option");
                    break;
            }
        }while (ch != 3);

    }

    public static int fastPower(int num, int exp) // O(log(base 2)N) because we halve exp every iteration
    {
        if(exp == 0)
            return 1;

        int result = 1;

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

    public static int iterativeFastPower(int num, int exp)
    {
        int result = 1;
        while (exp > 0)
        {
            if (exp % 2 == 1)
                result = result * num;

            num = num * num;
            exp = exp/2;
        }
        return result;
    } // NOTE : Integer Overflow is a possibility

    public static int recursiveFastPower(int num, int exp) // index == 1
    {
        if (exp == 0)
            return 1;

        int result =  recursiveFastPower(num, exp/2);
        if(exp % 2 == 1) // odd num
            return num * result * result;

        return result * result;
    } // NOTE : Integer Overflow is a problem

    public static int recursiveFastPowerMOD(int num, int exp) // index == 1
    {
        if (exp == 0)
            return 1;

        int result =  recursiveFastPowerMOD(num, exp/2);
        if(exp % 2 == 1) // odd num
            return ((num * result) % MOD * result) % MOD;

        return (result * result) % MOD;
    } // NOTE : Taking modulo with MOD to prevent integer overflow and allow for higher powers to be calculated

    public static int iterative(int num, int exp)
    {
        int result = 1;
        while (exp > 0) {
            result *= num;
            --exp;
        }
        return result;
    }

    public static int recursive(int num, int exp)
    {
        if(exp == 0)
            return 1;

        return num * recursive(num, exp-1);
    }
}
