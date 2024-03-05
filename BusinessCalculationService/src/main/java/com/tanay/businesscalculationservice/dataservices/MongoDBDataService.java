package com.tanay.businesscalculationservice.dataservices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Primary
@Qualifier("mongo")
public class MongoDBDataService implements DataService
{
    @Override
    public int[] retrieveData()
    {
        return new int[] {11, 22, 33, 44, 55,};
    }
}
