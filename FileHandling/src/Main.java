import com.sun.source.tree.TryTree;

import java.io.*;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        File file = new File("fomder");
        file.mkdir();
        file = new File("fomder/doge.txt");
        /*try
        {
            file.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }*/
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true)))
        {
            bw.write("Mission Doge To The Moon\n");
            System.out.println("Writing to file completed");
        }
        catch (IOException e)
        {
            System.out.println("Error while writing into the file");
        }
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            while(str != null)
            {
                System.out.println(str);
            }
            br.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("FileNotFoundException");
        }
        catch (IOException e)
        {
            System.out.println("IOException");
        }

    }
}