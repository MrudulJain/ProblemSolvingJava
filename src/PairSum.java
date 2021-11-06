
/*
 Given an Array of integers and an integer X, find a all pairs in array whose sum is equal to X
 A =  {3,4,4} ,   X = 8
 Output : 4, 4
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PairSum {
    public static void main(String[] args) {
        int choice, x, size;
        boolean result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Elements in Array: ");
        size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter Array: ");
        for (int i =0; i < size; i++)
            arr[i] = scanner.nextInt();
        System.out.println("Enter X: ");
        x = scanner.nextInt();
        System.out.printf("Enter your choice: \n1.Brute Force \n2.Two Pointer \n3.Map\n");
        choice = scanner.nextInt();
        switch (choice)
        {
            case 1:
                bruteforce(arr, x);
                break;
            case 2:
                twoPointer(arr, x);
                break;
            case 3:
                result = map(arr, x);
                if(!result)
                    System.out.println("No Pair Found");
                break;
            default:
                System.out.println("Enter correct Option");
                break;
        }
    }

    public static void bruteforce(int[] arr, int x)
    {
        for(int i = 0 ; i < arr.length; i++)
            for(int j=i+1; j < arr.length; j++)
                if(arr[i] + arr[j] == x)
                    System.out.println(arr[i] + "," + arr[j]);
    }

    public static  void twoPointer(int[] arr, int x)
    {
        int left = 0;
        int right = arr.length-1;
        Arrays.sort(arr);

        while (left < right)
        {
            if(arr[left] + arr[right] < x )
                left++;
            else if (arr[left] + arr[right] > x)
                right--;
            else {
                System.out.println(arr[left] + "," + arr[right]);
                left++;
            }
        }
    }

    public static boolean map(int[] arr, int x)
    {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i =0; i < arr.length; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // for duplicate elements we will store their count

        for (int i =0; i < arr.length; i++)
        {
            int rem = x - arr[i];
            map.put(arr[i], map.get(arr[i]) - 1);
            if(map.containsKey(rem) && map.get(rem) > 0)
            {
                System.out.println(arr[i] +"," +rem);
                return true;
            }
            // map.put(arr[i], map.get(arr[i]) + 1);
        }
        return false;
    }
}
