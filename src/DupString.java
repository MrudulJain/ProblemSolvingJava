import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
    Given a string with duplicate elements. Remove all consecutive duplicate elements and return string
	Input: AABBBBBCCCCCDDDXAA
	Output: ABCDXA

*/
public class DupString {
    public static void main(String[] args) {
        String s;
        StringBuilder output = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        s = scanner.next();
        output.append(s.charAt(0));
        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i) != s.charAt(i-1))
                output.append(s.charAt(i));
        }
        System.out.println("Output String: " +output);
    }
}
