import java.io.*;

public class ReadObject
{
    public static void main(String[] args)
    {
        try(FileInputStream fis = new FileInputStream("vehicles.dat"))
        {
            try (ObjectInputStream ois = new ObjectInputStream(fis))
            {
                Vehicle v1 = (Vehicle) ois.readObject();
                Vehicle v2 = (Vehicle) ois.readObject();
                System.out.println(v1.toString() + "\n" + v2.toString());
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
