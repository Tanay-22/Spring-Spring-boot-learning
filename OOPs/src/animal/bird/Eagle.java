package animal.bird;

public class Eagle extends Bird
{
    public String showInfo()
    {
        return "Eagle{" +
                "feather=" + feather +
                ", canFly=" + canFly +
                ", height=" + height +
                ", weight=" + weight +
                ", animalType='" + animalType + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
