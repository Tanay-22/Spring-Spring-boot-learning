package animal.reptile;

public class Crocodile extends Reptile
{
    public Crocodile()
    {
        super();
        egg = "Hard shelled";
    }
    public String showInfo()
    {
        return "Crocodile{" +
                "skin='" + skin + '\'' +
                ", egg='" + egg + '\'' +
                ", backbone=" + backbone +
                ", height=" + height +
                ", weight=" + weight +
                ", animalType='" + animalType + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
