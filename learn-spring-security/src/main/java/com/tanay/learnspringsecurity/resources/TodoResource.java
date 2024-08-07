package com.tanay.learnspringsecurity.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource
{
    Logger logger = LoggerFactory.getLogger(getClass());

    private static List<Todo> todos = List.of(
            new Todo("DogRaj", "Conquer the world"),
            new Todo("Kalu", "Eat biscoots")
    );


    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos()
    {
        return todos;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable String username)
    {
        return todos.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodosForSpecificUser(@PathVariable String username, @RequestBody Todo todo)
    {
        logger.info("Create {} for {}", username, todo);
    }
}

record Todo(String username, String description)
{}
