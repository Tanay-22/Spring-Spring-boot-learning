package vehicles;

public class Bike extends Vehicle
{
    private String handle;
    public Bike()
    {
        super();
    }
    public Bike(String engine, int wheels, int seats, int fuelTank, String lights,String handle)
    {
        super(engine, wheels, seats, fuelTank, lights);
        this.handle = handle;
    }
    String getHandle()
    {
        return this.handle;
    }

    @Override
    public String toString()
    {

        return "Bike{" + super.toString()+
                "handle='" + handle + '\'' +
                '}';
    }

    public void run()
    {
        System.out.println("Running bike");
        System.out.println(toString());
    }
}
