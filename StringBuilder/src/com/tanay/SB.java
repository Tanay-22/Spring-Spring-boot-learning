package com.tanay;

public class SB
{
    public static void main(String[] args)
    {
        StringBuilder str = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++)
            str.append(i);
        System.out.println(str);
        str.deleteCharAt(5);
        System.out.println(str);
    }
}
