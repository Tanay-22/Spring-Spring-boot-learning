package com.tanay.microservices.mockito.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Constants
{
    public static String s;

    static
    {
        try(InputStream is = Constants.class.getResourceAsStream("/config/string.txt"))
        {
            if(is == null)
                throw new FileNotFoundException("File 'string.txt' not found in the package");
            s = new String(is.readAllBytes());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
