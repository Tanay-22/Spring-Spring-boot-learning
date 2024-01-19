

/*class Data
{
    private Object obj;

    public Data(Object obj)
    {
        this.obj = obj;
    }

    public Object getObj()
    {
        return obj;
    }

    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public String toString()
    {
        return "Data{" +
                "obj=" + obj +
                '}';
    }
}*/

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

class Data
{
    public <E> void printListData(List<E> list)
    {
        for(E element: list)
            System.out.println(element);
    }

    public <E> void printArrayData(E[] arrayData)
    {
        for (E element : arrayData)
            System.out.println(element);
    }
}

class GenericClass<T>
{
    private T data;

    public GenericClass(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return data;
    }

    @Override
    public String toString()
    {
        return "GenericClass{" +
                "data=" + data +
                '}';
    }
}

public class App
{
    public static void main(String[] args)
    {
        /*Data data = new Data("Data contents");
        String str = (String) data.getObj();
        System.out.println(str);*/

        /*Tyipe casting takes more time, so generic class is prefered*/

        /*GenericClass<String> gc = new GenericClass<String>("Data 2");
        String str = gc.getData();
        System.out.println(str);*/

        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Data data = new Data();
        data.printListData(list);

        List<String> list2 = new ArrayList<>();
        list2.add("One");
        list2.add("Two");
        list2.add("Three");
        list2.add("Four");
*/
        String strArr[] = {"One", "Two", "Three"};
        Integer interArr[] = {1, 2, 3};
        Data data = new Data();
        data.printArrayData(strArr);
        data.printArrayData(interArr);
    }
}
