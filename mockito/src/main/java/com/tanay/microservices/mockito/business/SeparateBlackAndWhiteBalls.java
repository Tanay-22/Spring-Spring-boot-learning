package com.tanay.microservices.mockito.business;

public class SeparateBlackAndWhiteBalls
{
    public long minimumSteps(String s)
    {
        long total = 0L;
        long count = 0L;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            char ch = s.charAt(i);
            if(ch == '0')
                count++;
            else
            {
                total += count;
                // count = 0;
            }
        }
        return total;
    }
}
