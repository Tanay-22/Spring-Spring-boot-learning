import java.util.*;
import java.io.*;
public class FileWithScanner
{
    public static void main(String[] args)
    {
        try
        {
            Scanner sc =new Scanner(new File("fomder/doge.txt "));
            String str;
            while(sc.hasNext())
            {
                str = sc.nextLine();
                System.out.println(str);
            }
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error while reading file");
        }
    }
}
