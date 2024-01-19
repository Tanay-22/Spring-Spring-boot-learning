package animal;

public class Animal
{
    protected int height, weight;
    protected String animalType, bloodType;

    public Animal()
    {
        height = weight = 0;
        animalType = bloodType = "unknown";
    }

    public String showInfo()
    {
        return "Animal{" +
                "height=" + height +
                ", weight=" + weight +
                ", animalType='" + animalType + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
