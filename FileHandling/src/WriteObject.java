import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject
{
    public static void main(String[] args)
    {
        Vehicle bike = new Vehicle("bike",8662);
        Vehicle car = new Vehicle("Car",1234);
        try(FileOutputStream fos = new FileOutputStream("vehicles.dat"))
        {
            try(ObjectOutputStream oos = new ObjectOutputStream(fos))
            {
                oos.writeObject(bike);
                oos.writeObject(car);
                System.out.println("Object written onto the file");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("FileNotFoundException");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("IOException");
        }
    }
}
