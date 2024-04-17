package com.tanay.restfulwebservices.hateoas.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Post
{
    @Id
    @GeneratedValue
    private int id;

    @Size(min=10, max=100)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)  //lazily loaded,
    // meaning it won't be loaded from the database until it's actually accessed in your code
    @JsonIgnore
    private User user;

    public Post()
    {

    }

    public Post(int id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
