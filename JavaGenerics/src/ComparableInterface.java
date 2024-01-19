
class Data2<T extends Comparable<T>> implements Comparable<T>
{
    private T myVariable;

    public Data2(T myVariable)
    {
        this.myVariable = myVariable;
    }

    public T getMyVariable()
    {
        return myVariable;
    }

    @Override
    public String toString()
    {
        return "Data2{" +
                "myVariable=" + myVariable +
                '}';
    }

    @Override
    public int compareTo(T o)
    {
        return getMyVariable().compareTo(o);
    }
}

public class ComparableInterface
{
    public static void main(String[] args)
    {
        Data2<Integer> data = new Data2<Integer>(45);
        System.out.println(data.compareTo(42));
    }
}
