/*
    Q. Calculate the GCD (HCF) of 2 numbers
    Sol :
    Euclid's Theorem : If a = bq + r, then gcd(a, b) = gcd(b, r)

    Expansion :
    gcd(a,b) = gcd(b,r)
    gcd(b,r) = gcd(r, r1)
    gcd(r, r1) = gcd(r1, r2)
    .
    .
    gcd(r(n-1), rn) = gcd(rn, 0) = rn  // GCD of any number with 0 is the number itself
    Therefore, gcd(a,b) = ri
    We can calculate the remainder "r" using the operation => r = a % b;

    Proof:

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gcd = -1;
        System.out.println("Enter the numbers (a,b): ");
        int a = input.nextInt();
        int b = input.nextInt();

        while (true)
        {
            System.out.printf("\n1.Brute Force O(n)\t2.Prime Factor Method O(sqrt(n))\t3.Euclid's Method O(logN)");
            System.out.println("Choose your option: ");
            int ch = input.nextInt();
            switch (ch)
            {
                case 1:
                    gcd = bruteForce(a, b);
                    break;
                case 2:
                    gcd = pfMethod(a, b);
                    break;
                case 3:
                    gcd = euclid(a, b);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter the correct option");
                    break;
            }
            System.out.println("GCD = " + gcd);
        }
    }

    public static int bruteForce(int a, int b)
    {
        for (int i = Math.max(a, b); i > 0; i--)
        {
            if(a%i == 0 && b%i == 0)
                return i;
        }
        return -1;
    }

    public static int pfMethod(int a, int b)
    {
        Map<Integer, Integer> primefactorsA = findPrimeFactors(a);
        Map<Integer, Integer> primefactorsB = findPrimeFactors(b);
        int gcd = 1;

        for (int i : primefactorsA.keySet())
            if(primefactorsB.containsKey(i))
                gcd *=  (int) Math.pow(i, Math.min(primefactorsA.get(i), primefactorsB.get(i)));

        return gcd;
    }

    public static Map<Integer, Integer> findPrimeFactors (int num)
    {
        Map<Integer, Integer> pfMap = new HashMap<>(); // Map that stores the prime factors and the number of times they occur
        for (int i = 2; i <= Math.sqrt(num); i++)
            while (num % i == 0) {
                num = num/i;
                pfMap.put(i, pfMap.getOrDefault(pfMap.get(i), 0) + 1);
            }

        if(num > 1) // i.e num was a prime factor
            pfMap.put(num, 1);

        return pfMap;
    }

    public static int euclid(int a, int b)
    {
        // Theorem : gcd(a,b) = gcd(b,r), where r = a%b (remainder)
        if(a == 0)
            return b;

        return euclid(b, a%b);
    }
}
