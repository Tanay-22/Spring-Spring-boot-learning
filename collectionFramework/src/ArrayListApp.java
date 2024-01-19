import java.util.ArrayList;

public class ArrayListApp
{
    static ArrayList<String> listNames = new ArrayList<>();

    void removeNameByPosition(int position)
    {
        listNames.remove(position);
    }

    void removeNameByString(String name)
    {
        listNames.remove(name);
    }

    void displayList(ArrayList<String> names)
    {
        for(String name : names)
        {
            System.out.println(name);
        }
    }
    void modifyName(int pos, String newName)
    {
        listNames.set(pos, newName);
    }
    public static void main(String args[])
    {
        listNames.add("DOGRAJ");
        listNames.add("Tanay");
        listNames.add("Ashish");
        listNames.add("Tarun");
        listNames.add("Shivali");
        listNames.add("Dimdi");
        ArrayListApp app = new ArrayListApp();
        app.displayList(listNames);
        app.removeNameByPosition(0);
        System.out.println("*******");
        app.displayList(listNames);
        System.out.println("*******");
        app.modifyName(1,"Piddi");
        app.displayList(listNames);
    }
}
