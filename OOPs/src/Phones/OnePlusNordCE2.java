package Phones;

public class OnePlusNordCE2 implements Phone
{

    @Override
    public String processor()
    {
        return "Dimensity 900 Octa-core";
    }

    @Override
    public String OS()
    {
        return "OxygenOS 13.0";
    }

    @Override
    public int spaceInGB()
    {
        return 128;
    }
}
