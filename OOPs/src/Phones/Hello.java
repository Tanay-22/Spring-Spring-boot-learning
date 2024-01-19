package Phones;
import Phones.OnePlusNordCE2;
public class Hello
{
    public static void main(String[] args)
    {
        Phone phone = new OnePlusNordCE2();
        System.out.println("Processor: "+phone.processor());
        System.out.println("Operating System: "+phone.OS());
        System.out.println("Storage: "+phone.spaceInGB() +" GB");

    }
}
