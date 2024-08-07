import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTest
{
    private Sum sum = new Sum();

    @Test
    void calculate()
    {
        assertEquals(26, sum.calculate(new int[]{1, 3, 4, 6, 7, 5}));
    }
}