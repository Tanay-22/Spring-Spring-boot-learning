package vehicles;

public class Car extends Vehicle
{
    private String steering, musicSystem, airConditioner, fridge, entertainmentSystem;

    public Car()
    {
        super();
    }
    public Car(String engine, int wheels, int seats, int fuelTank, String lights,
               String steering, String musicSystem, String airConditioner,
               String fridge, String entertainmentSystem)
    {
        super(engine, wheels, seats, fuelTank, lights);
        this.steering = steering;
        this.musicSystem = musicSystem;
        this.airConditioner = airConditioner;
        this.fridge = fridge;
        this.entertainmentSystem = entertainmentSystem;
    }

    public String getSteering()
    {
        return steering;
    }

    public String getMusicSystem()
    {
        return musicSystem;
    }

    public String getAirConditioner()
    {
        return airConditioner;
    }

    public String getFridge()
    {
        return fridge;
    }

    public String getEntertainmentSystem()
    {
        return entertainmentSystem;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "steering='" + steering + '\'' +
                ", musicSystem='" + musicSystem + '\'' +
                ", airConditioner='" + airConditioner + '\'' +
                ", fridge='" + fridge + '\'' +
                ", entertainmentSystem='" + entertainmentSystem + '\'' +
                '}';
    }
}
