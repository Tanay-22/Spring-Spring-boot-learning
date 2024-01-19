package animal.fish;

public class Eel extends Fish
{
    private String special;

    public Eel()
    {
        super();
        this.special = "Releases electric shock";
    }

    public String showInfo()
    {
        return "Eel{" +
                "special='" + special + '\'' +
                ", waterBone=" + waterBone +
                ", gills=" + gills +
                ", height=" + height +
                ", weight=" + weight +
                ", animalType='" + animalType + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
