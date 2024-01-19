package Predicates;

import java.util.function.IntPredicate;

public class App
{
    public static void main(String[] args)
    {
        IntPredicate lessThan18 = (value) -> value < 18;
        IntPredicate moreThan10 = (value) -> value > 10;
        //System.out.println(lessThan18.test(21));
        new App().demo(13, lessThan18, moreThan10);
    }

    public void demo(int x, IntPredicate lessThan18, IntPredicate moreThan10)
    {
        if(lessThan18.test(x) && moreThan10.test(x))
            System.out.println("Less than 18 and more than 10");
        else
            System.out.println("Invalid");
    }
}




