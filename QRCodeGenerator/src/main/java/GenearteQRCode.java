import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.Paths;

public class GenearteQRCode
{
    public static void main(String[] args)
    {
        String data = "";
        String path = "C:\\Users\\Public\\Desktop\\qr.jpg";

        BitMatrix matrix = null;
        try
        {
            matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);
        }
        catch (WriterException e)
        {
            throw new RuntimeException(e);
        }

        try
        {
            MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        System.out.println("QR code generated");
    }
}
