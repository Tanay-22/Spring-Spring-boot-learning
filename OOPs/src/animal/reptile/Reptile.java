package animal.reptile;

import animal.Animal;

public class Reptile extends Animal
{
    protected String skin, egg;
    protected boolean backbone;

    public Reptile()
    {
        height = 5;  weight = 20;  animalType = "Reptile";   bloodType = "Cold";
        this.skin = "Dry Skin";
        this.backbone = true;
        this.egg = "Soft shelled";
    }
    public String showInfo()
    {
        return "Reptile{" +
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
