package com.tanay.microservices.mockito.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessLogicStubTest
{
    @Test
    void findTheGreatestFromAllData_1()
    {
        DataServiceStub dataServiceStub = new DataServiceStub();
        BusinessLogic businessLogic = new BusinessLogic(dataServiceStub);
        int result = businessLogic.findTheGreatestFromAllData();
        assertEquals(67, result);
    }

    @Test
    void findTheGreatestFromAllData_2()
    {
        DataServiceStub dataServiceStub = new DataServiceStub();
        BusinessLogic businessLogic = new BusinessLogic(dataServiceStub);
        int result = businessLogic.findTheGreatestFromAllData();
        assertEquals(54, result);
    }
}

class DataServiceStub implements DataService
{

    @Override
    public int[] retrieveAllData()
    {
        return new int[] {25, 15, 67, 54};
    }
}