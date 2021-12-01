import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/*
    Used to solve equation with two variables, if the given condition is satisfied :
    Given Eq: ax + by = c
    c = gcd(a,b)
 */

public class ExtendedGCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        AtomicInteger x = new AtomicInteger(1);
        AtomicInteger y = new AtomicInteger(1);
        int gcd = extendedGCD(a, b, x, y);
        System.out.println("Atomic Integer Object Method");
        System.out.println("GCD = " +gcd);
        System.out.println("x = " + x + " y = " + y);

        int[] result = extendedGCD(a, b);
        System.out.println("Array Method");
        System.out.println("GCD = " +result[0]);
        System.out.println("x = " + result[1] + " y = " + result[2]);
    }

    public static int extendedGCD(int a, int b, AtomicInteger x, AtomicInteger y)
    {
        if(b == 0) {
            x.set(1);
            y.set(0); // y can be anything [as b = 0] but we are taking it as 0
            return a;
        }

        AtomicInteger x1 = new AtomicInteger(1);
        AtomicInteger y1 = new AtomicInteger(1);
        int gcd = extendedGCD(b, a%b, x1, y1);
        System.out.println("x1 = " +x1);
        System.out.println("y1 = " + y1);
        x.set(y1.get());
        y.set((x1.get()) - ((a/b)*y1.get()));
        return gcd;
    }

    public static int[] extendedGCD(int a, int b)
    {
        if(b == 0) {
            int[] result = new int[3];
            int gcd = a;
            result[0] = gcd;
            result[1] = 1;
            result[2] = 0; // y can be anything [as b = 0] but we are taking it as 0
            return result;
        }

        int[] result = extendedGCD(b, a%b);
        int x1 = result[1];
        int y1 = result[2];
        int x = y1;
        int y = x1 - (a/b)*y1;
        result[1] = x;
        result[2] = y;

        return result;
    }

}
