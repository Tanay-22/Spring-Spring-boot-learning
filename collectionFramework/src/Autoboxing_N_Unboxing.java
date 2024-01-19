import java.util.ArrayList;

class IntWrapper
{
    int intValue;
    public IntWrapper(int intValue)
    {
        this.intValue = intValue;
    }

    public int getIntValue()
    {
        return intValue;
    }

    public void setIntValue(int intValue)
    {
        this.intValue = intValue;
    }
}

public class Autoboxing_N_Unboxing
{

    public static void main(String[] args)
    {
        /*ArrayList<Integer> studentNumbers = new ArrayList<>();
        studentNumbers.add(14);
        System.out.println(studentNumbers.get(0));*/

        ArrayList<IntWrapper> studentNumbers = new ArrayList<>();
        studentNumbers.add(new IntWrapper(12));     //boxing
        System.out.println(studentNumbers.get(0).getIntValue());    // un-boxing

    }
}
