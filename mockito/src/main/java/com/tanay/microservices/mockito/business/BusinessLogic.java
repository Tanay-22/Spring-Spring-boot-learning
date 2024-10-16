package com.tanay.microservices.mockito.business;

public class BusinessLogic
{
    private DataService dataService;

    public BusinessLogic(DataService dataService)
    {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData()
    {
        int[] data = dataService.retrieveAllData();
        int greatValue = Integer.MIN_VALUE;
        for(int value: data)
            greatValue = Math.max(greatValue, value);

        return greatValue;
    }
}

interface DataService
{
    int[] retrieveAllData();
}
