package com.tanay.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController
{

    private MappingJacksonValue filterFunction(Object someBean, String ... str)
    {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(str);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @GetMapping("/filtering")
    public MappingJacksonValue filtering()
    {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        return filterFunction(someBean, "field2");
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList()
    {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                                            new SomeBean("value4", "value5", "value6"));

        return filterFunction(list, "field2", "field3");
    }
}
