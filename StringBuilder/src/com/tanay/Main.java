package com.tanay;

public class Main
{
    public static void main(String[] args)
    {
        String a = "DogRaj";
        String b = "DogRaj";    // both pointing to same object
        System.out.println(a == b); //true

        String aa = new String("DogRaj");
        String bb = new String("DogRaj");   // different objects
        System.out.println(aa == bb);   //false

        float num = 321.45673f;
        System.out.printf("Formatted num = %.2f\n", num);
        System.out.printf("Pie = %.3f", Math.PI);
    }
}
