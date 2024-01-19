import java.util.ArrayList;
import java.util.List;

class Vehicle
{
    private int id;

    public Vehicle(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Vehicle{" +
                "id=" + id +
                '}';
    }

    void info()
    {
        System.out.println("Vehicle Id is : " + getId());
    }
}

class Car extends Vehicle
{
    private String model;

    public Car(int id, String model)
    {
        super(id);
        this.model = model;
    }

    public String getModel()
    {
        return model;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

    @Override
    void info()
    {
        System.out.println("Car Model is : " + getModel());
    }
}
public class WildCards
{
    public static void main(String[] args)
    {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle(10));
        list.add(new Vehicle(11));
        list.add(new Vehicle(12));
        list.add(new Vehicle(13));
        list.add(new Car(14, "SS"));
        //list.add(new String("String object"));
        display(list);

    }
    public static void display(List<? extends Vehicle> list)    // WildCard character
    {
        for (Vehicle obj : list)
            obj.info();
    }
}
