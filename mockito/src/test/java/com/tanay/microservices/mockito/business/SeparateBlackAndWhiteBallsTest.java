package com.tanay.microservices.mockito.business;

import com.tanay.microservices.mockito.config.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparateBlackAndWhiteBallsTest
{
    private SeparateBlackAndWhiteBalls balls = new SeparateBlackAndWhiteBalls();

    @Test
    void test1()
    {
        assertEquals(1, balls.minimumSteps("101"));
    }

    @Test
    void test2()
    {
        assertEquals(2, balls.minimumSteps("100"));
    }

    @Test
    void test3()
    {
        assertEquals(0, balls.minimumSteps("0111"));
    }

    @Test
    void test4()
    {
        assertEquals(6, balls.minimumSteps("11000111"));
    }

    @Test
    void test5()
    {
        assertEquals(2500000000L, balls.minimumSteps(Constants.s));
    }
}