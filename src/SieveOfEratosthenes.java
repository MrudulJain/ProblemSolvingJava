
/*
    Q. Generate all prime numbers in a given range [a,b]
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println("Enter the numbers between which primes are to be calculated (a,b): ");
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        long startTime1 = System.currentTimeMillis();
        bruteforce(a, b);
        long stopTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        bruteforceOptimized(a, b);
        long stopTime2 = System.currentTimeMillis();

        long startTime3 = System.currentTimeMillis();
        sieve(a, b);
        long stopTime3 = System.currentTimeMillis();

        //Results
        System.out.println("Time taken by Brute Force(ms): " + (stopTime1 - startTime1));
        System.out.println("Time taken by Optimized Brute Force(ms): " + (stopTime2 - startTime2));
        System.out.println("Time taken by Sieve Of Eratosthenes(ms): " + (stopTime3 - startTime3));
    }

    public static void sieve(long a, long b) // O(n*log(log(n)))
    {
        int limit = (int) Math.max(a,b);
        boolean[] prime = new boolean[(int)Math.max(a,b) + 1]; // defaults to false
        Arrays.fill(prime, true);


        for (long i = 2; i <= limit; i++)
        {
            if(prime[(int) i])
                for (long j = i * i; j <= limit; j= j+i)
                        prime[(int) j] = false;
        }

        for (long i = Math.min(a, b); i <= limit; i++)
            if(prime[(int) i])
                System.out.println(i);
    }

    public static void bruteforce(long a, long b) //  O(N^2)
    {
            for(long i = Math.min(a,b); i <= Math.max(a,b); i++)
            {
                int counter = 0;
                int j = 1;
                for (; j <=i; j++)
                {
                    if(i % j == 0)
                        counter ++;
                }
                if(counter > 2) // prime number is divisible by 1 and itself
                    continue;
                else
                    System.out.println(i);
            }
    }

    public static void bruteforceOptimized(long a, long b) // O([B-A] * sqrt(B)), B = Bigger number
    {
        for(long i = Math.min(a,b); i <= Math.max(a,b); i++)
        {
            boolean flag = true;
            for (int j = 2; j <= (int) Math.sqrt(i); j++)
            {
                if(i % j == 0)
                    flag = false;
            }
            if (flag)
                System.out.println(i);
        }
    }
}
