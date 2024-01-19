package animal.fish;

import animal.Animal;

public class Fish extends Animal
{
    protected boolean waterBone;
    protected boolean gills;

    public Fish()
    {
        super();
        animalType = "Fish";
        this.waterBone = true;
        this.gills = true;
    }


    public String showInfo()
    {
        return "Fish{" +
                "waterBone=" + waterBone +
                ", gills=" + gills +
                ", height=" + height +
                ", weight=" + weight +
                ", animalType='" + animalType + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
