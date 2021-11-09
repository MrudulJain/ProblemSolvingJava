/*

Given an array of integers, a target integer = X and a natural number = C
Find all possible sets of integers of Cardinality (size) = C whose sum of elements = X
Sample Input :
Arr = {1, 2, 3, 4, 5}
C = 2
X = 5
Output :
2,3
1,4

Solution:
Approach 1 : Brute Force
1) Find power set of the array = 2^n elements
2) From the power set, find all sets with cardinality = C
3) For each set with cardinality = C, check its sum of elements = desired sum

Approach 2:
1) Instead of finding PowerSet, directly find all subsets of cardinality (size) = c
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        int targetVal, c, sizeOfArr;
        Scanner scanner = new Scanner(System.in);

        // INPUT
        System.out.println("Enter size of Array: ");
        sizeOfArr = scanner.nextInt();
        int[] arr = new int[sizeOfArr];
        System.out.println("Enter Array: ");
        for (int i =0; i < sizeOfArr; i++)
            arr[i] = scanner.nextInt();
        System.out.println("Enter target value: ");
        targetVal = scanner.nextInt();
        System.out.println("Enter Cardinality of set: ");
        c = scanner.nextInt();
        // INPUT OVER

        System.out.printf("Enter your choice: \n1.Brute Force \n2.Optimized \n");
        int choice = scanner.nextInt();
        ArrayList<ArrayList<Integer>> result;
        switch (choice)
        {
            case 1:
                int i = arr.length - 1;
                result = findPowerSet(arr, i, c);
                System.out.println("PowerSet is: " +result);
                result = returnCheckSum(result, targetVal, c);
                System.out.println("The subSets of cardinality \"" +c+ "\" whose sum = " +targetVal+ " are: ");
                System.out.println(result);
                break;
            case 2:
                int len = arr.length - 1;
                result = optimizedSol(arr, len, c, targetVal);
                System.out.println("Optimized PowerSet is: " + result);
                System.out.println("The subSets of cardinality \"" +c+ "\" whose sum = " +targetVal+ " are: ");
                result = returnCheckSum(result, targetVal, c);
                System.out.println(result);
                break;
            default:
                System.out.println("Enter correct Option");
                break;
        }
    }

    public static ArrayList<ArrayList<Integer>> findPowerSet(int[] arr, int i, int c)
    {
        ArrayList<ArrayList<Integer>> powerSet;

        if(i < 0) // this will execute only once when i = -1
        {
            powerSet = new ArrayList<ArrayList<Integer>>();
            powerSet.add(new ArrayList<Integer>());
            return powerSet;
        }

        powerSet = findPowerSet(arr, i - 1, c);
        int nextInt = arr[i];
        ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();

        for (ArrayList<Integer> subset : powerSet) {
            ArrayList<Integer> newSubset = new ArrayList<Integer>();
            newSubset.addAll(subset);
            newSubset.add(nextInt);
            // subset.add(nextInt); ---> WRONG, doing this will update the PowerSet
            moreSubsets.add(newSubset);
        }
        powerSet.addAll(moreSubsets);

        return powerSet;
    }

    public static ArrayList<ArrayList<Integer>> returnCheckSum (ArrayList<ArrayList<Integer>> result, int targetVal, int c)
    {
        ArrayList<ArrayList<Integer>> cSets = new ArrayList<ArrayList<Integer>>(); // Set which contains sets of cardinality = c
        int sum;

        for(ArrayList<Integer> subSet : result)
        {
            sum = 0;
            if(subSet.size() == c)
                for (int i = 0; i < subSet.size(); i++)
                    sum += subSet.get(i);

            if(sum == targetVal)
                cSets.add(subSet);
        }
        return cSets;
    }

    public static ArrayList<ArrayList<Integer>> optimizedSol(int[] arr, int i, int c, int targetVal)
    {
        ArrayList<ArrayList<Integer>> finalSet;

        if(i < 0) // this will execute only once when i = -1
        {
            finalSet = new ArrayList<ArrayList<Integer>>();
            finalSet.add(new ArrayList<Integer>());
            return finalSet;
        }

        finalSet = optimizedSol(arr, i - 1, c, targetVal);
        int nextInt = arr[i];
        ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();

        for (ArrayList<Integer> subset : finalSet) {
            // OPTIMIZATION : We are only adding those sets (to finalSet) whose cardinality is less than or equal to c and ignoring others
            // so, we are checking if current size of subset + 1(because we will add nextInt to it) is greater than c or not
            if (subset.size()+1 > c)
                continue;
            ArrayList<Integer> newSubset = new ArrayList<Integer>();
            newSubset.addAll(subset);
            newSubset.add(nextInt);
            moreSubsets.add(newSubset); // can't directly add to finalSet otherwise for-loop condition will get updated
        }
        finalSet.addAll(moreSubsets);
        return finalSet;
    }
}


