import java.util.*;
import java.util.Iterator;

public class LLApp
{
    void printLL1(List<String> ll)
    {
        for(String name : ll)
            System.out.println(name);
        System.out.println("************");
    }

    void printLL2(List<String> l)
    {
        Iterator<String> iterator = l.iterator();
        while(iterator.hasNext())
        {
            System.out.println("Element: " + iterator.next());
        }
    }
    public static void main(String[] args)
    {
        List<String> countries = new LinkedList<>();
        countries.add("India");
        countries.add("USA");
        countries.add("Poland");
        countries.add("Egypt");
        countries.add("Thailand");
        countries.add("Russia");

        LLApp app = new LLApp();

        app.printLL1(countries);
//        System.out.println(countries);
        /*new LLApp().printLL1(countries);
        countries.add(3,"Argentina");
        new LLApp().printLL1(countries);
        countries.set(2,"Nepal");
        new LLApp().printLL1(countries);
        countries.remove();
        new LLApp().printLL1(countries);*/

        countries.sort(null);
        app.printLL1(countries);

        Collections.reverse(countries);
        app.printLL1(countries);
    }
}
