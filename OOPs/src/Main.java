import animal.*;
import animal.fish.Eel;
import animal.reptile.Crocodile;
import animal.reptile.Reptile;

public class Main
{
    public static void main(String[] args)
    {
//        Animal animal = new Animal();
//        System.out.println(animal.showInfo());
//
//        Reptile rep = new Reptile();
//        System.out.println(rep.showInfo());
//
//        Crocodile croc = new Crocodile();
//        System.out.println(croc.showInfo());
//
//        Eel eel = new Eel();
//        System.out.println(eel.showInfo());
        Enum num = Enum.FOUR;
        switch (num)
        {
            case ONE ->
            {
                System.out.println(1);
            }
            case TWO ->
            {
                System.out.println(2);
            }
            case THREE ->
            {
                System.out.println(3);
            }
            case FOUR ->
            {
                System.out.println(4);
            }
            case FIVE ->
            {
                System.out.println(5);
            }
        }
    }
}
