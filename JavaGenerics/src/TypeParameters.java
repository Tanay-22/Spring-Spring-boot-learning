
/*  T - Type
*   E - Element
*   K - Key
*   N - Number
*   V - Value
* */

class DataKey<K extends Number,V extends TypeParameters>
{
    private K key;
    private V value;

    public DataKey(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey()
    {
        return key;
    }

    public V getValue()
    {
        return value;
    }

    public <E,N extends Number> void display(E element, N number)
    {
        System.out.println("Element: "+ element + " Number: "+ number);
    }

    @Override
    public String toString()
    {
        return "Data{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
public class TypeParameters
{
    public static void main(String[] args)
    {
        /*DataKey<Integer, String> data = new DataKey<Integer, String>(1, "Doge");
        System.out.println(data.toString());*/

        /*DataKey<Integer, String> data = new DataKey<Integer, String>(1,"String");
        data.display("element", 1.8f);*/

        DataKey<Integer, TypeParameters> data = new DataKey<Integer, TypeParameters>(1, new TypeParameters());
        data.display('$', 1);
        data.getValue().test();
    }

    public void test()
    {
        System.out.println("Testing.....");
    }
}
