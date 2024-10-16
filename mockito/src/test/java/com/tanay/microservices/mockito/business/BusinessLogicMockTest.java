package com.tanay.microservices.mockito.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)     // for 2nd implementation
class BusinessLogicMockTest
{
    @Test
    void findTheGreatestFromAllData_1()
    {
        DataService mock = mock(DataService.class);
        when(mock.retrieveAllData()).thenReturn(new int[] {25, 15, 67, 54});
        BusinessLogic businessLogic = new BusinessLogic(mock);
        assertEquals(6, businessLogic.findTheGreatestFromAllData());
    }

    // Easy Way to implement Mockito

    @Mock
    private DataService dataService;

    @InjectMocks
    private BusinessLogic businessLogic;

    @Test
    void findTheGreatestFromAllData_2()
    {
        when(dataService.retrieveAllData()).thenReturn(new int[] {25, 15, 67, 54});
        assertEquals(67, businessLogic.findTheGreatestFromAllData());
    }
}