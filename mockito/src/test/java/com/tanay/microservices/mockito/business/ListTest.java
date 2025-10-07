package com.tanay.microservices.mockito.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListTest
{
    @Test
    void simpleTest()
    {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3);

        assertEquals(3, listMock.size());
    }

    @Test
    void multipleReturnTest()
    {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(1).thenReturn(2);

        assertEquals(1, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    void parametersTest()
    {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("Hemlo World").thenReturn(2);

        assertEquals("Hemlo World", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }
}