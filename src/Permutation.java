public class Permutation {
    public static void main(String[] args) {
        String a = "ABCD";
        permute(a.toCharArray());
    }
    public static void permute(char[] str)
    {
        backtrack(str , 0);
    }

    public static void backtrack(char[] str , int index)
    {
        if(index == str.length)
        {
            System.out.println(String.valueOf(str));
        }
        for(int i = index; i < str.length;i++)
        {
            // Swapping
            swap(str, i, index);
            backtrack(str, index+1);
            swap(str, i, index);
        }

    }
    // Java only supports call by value.
    public static void swap(char[] str, int x , int y)
    {
        char z = str[x];
        str[x] = str[y];
        str[y] = z;
    }

}
