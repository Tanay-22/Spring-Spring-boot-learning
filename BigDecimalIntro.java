import java.math.*;
public class BigDecimalIntro 
{
    public static void main(String[] args) 
	{
		double x = 1.05, y = 2.55;
		System.out.println(x+y); // 3.5999999999999996

		BigDecimal d1 = new BigDecimal(1.05);
		BigDecimal d2 = new BigDecimal(2.55);
		System.out.println(d1.add(d2)); //  3.5999999999999998667732370449812151491641998291015625

        BigDecimal d3 = new BigDecimal("1.05");
		BigDecimal d4 = new BigDecimal("2.55");
        System.out.println(d3.add(d4)); //  3.60
		
        System.out.println("Bar\u00E7a");

	}    
}
