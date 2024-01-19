package vehicles;

import java.security.PublicKey;

public class Vehicle
{


    private String engine, lights;
    private int wheels, seats, fuelTank;
    public Vehicle()
    {
        this.engine = "petrol";
        this.wheels = 4;
        this.seats = 4;
        this.fuelTank = 35;
        this.lights = "LED";
    }
    public Vehicle(String engine, int wheels, int seats, int fuelTank, String lights)
   {
        this.engine = engine;
        this.wheels = wheels;
        this.seats = seats;
        this.fuelTank = fuelTank;
        this.lights = lights;
   }
    public String getEngine()
    {
        return engine;
    }

    public String getLights()
    {
        return lights;
    }

    public int getWheels()
    {
        return wheels;
    }

    public int getSeats()
    {
        return seats;
    }

    public int getFuelTank()
    {
        return fuelTank;
    }

    @Override
    public String toString()
    {
        return "engine='" + engine + '\'' +
                ", lights='" + lights + '\'' +
                ", wheels=" + wheels +
                ", seats=" + seats +
                ", fuelTank=" + fuelTank+", "
                ;
    }

    public void run()
    {
        System.out.println("Running Vehicle");
    }
}
