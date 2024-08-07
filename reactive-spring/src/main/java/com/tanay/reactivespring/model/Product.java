package com.tanay.reactivespring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
/*  No @Entity annotation because there is no use of JPA/Hibernate which is non-reactive  */
public class Product
{
    @Id
    private int id;
    private String name;
}
