package com.tanay.todoappbackend.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class TodoResource
{
    private TodoService todoService;

    public TodoResource(TodoService todoService)
    {
        this.todoService = todoService;
    }

    @GetMapping("/basicauth")
    public String basicAuthCheck()
    {
        return "Success";
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable("username") String username)
    {
        return todoService.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable("username") String username, @PathVariable("id") int id)
    {
        return todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("username") String username, @PathVariable("id") int id)
    {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();  // 204
    }

    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable("username") String username, @PathVariable("id") int id,
                                           @RequestBody Todo todo)
    {
        todoService.updateTodo(todo);
        return todo;
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo)
    {
        Todo createdTodo =  todoService.addTodo(username, todo.getDescription(),
                                                todo.getTargetDate(), todo.isDone());
        return createdTodo;
    }
}
