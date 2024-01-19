import java.util.*;

class Data
{
    private String name;

    public Data(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "Data{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class App
{
    public static void main(String[] args)
    {
        List<Data> list = new ArrayList<Data>();
        list.add(new Data("DogRaj"));
        list.add(new Data("Marc"));
        list.add(new Data("Ronald"));
        list.add(new Data("Andreas"));
        list.add(new Data("Jules"));
        list.add(new Data("Gavi"));
        list.add(new Data("Pedri"));
        list.add(new Data("Sergi"));

        list.forEach(temp ->
        {
            System.out.println(temp.getName());
        });

    }
}
