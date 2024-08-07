public class Sum
{
    public int calculate(int[] arr)
    {
        int sum = 0;
        for (int i: arr)
            sum += i;

        return sum;
    }
}
