import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Names implements Comparable<Names>
{
    private String name;

    public Names(String name)
    {
        this.name = name;
    }

    @Override
    public int compareTo(Names obj)
    {
        if (name.length() == obj.name.length())
            return 0;
        else if (name.length() < obj.name.length())
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }

    @Override
    public String toString()
    {
        return  name;
    }
}

public class ComparableInterfaces
{
    void printList(List<Names> list)
    {
        ListIterator<Names> iterator = list.listIterator();
        while(iterator.hasNext())
        {
            System.out.println("Element : " + iterator.next());
        }
    }

    public static void main(String[] args)
    {
        List names = new LinkedList<>();
        names.add(new Names("DogRaj"));
        names.add(new Names("Tanay"));
        names.add(new Names("Ashish"));
        names.add(new Names("Tarun"));

        ComparableInterfaces app = new ComparableInterfaces();
        app.printList(names);
    }
}
