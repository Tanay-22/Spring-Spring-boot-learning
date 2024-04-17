package com.tanay.todoappbackend.todo;

import com.tanay.todoappbackend.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoJpaResource
{
    private TodoService todoService;
    private TodoRepository todoRepository;


    public TodoJpaResource(TodoService todoService, TodoRepository todoRepository)
    {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/basicauth")
    public String basicAuthCheck()
    {
        return "Success";
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable("username") String username)
    {
//        return todoService.findByUsername(username);
        return todoRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable("username") String username, @PathVariable("id") int id)
    {
//        return todoService.findById(id);
        return todoRepository.findById(id).get();

    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("username") String username, @PathVariable("id") int id)
    {
//        todoService.deleteById(id);
//        return ResponseEntity.noContent().build();  // 204

        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable("username") String username, @PathVariable("id") int id,
                                           @RequestBody Todo todo)
    {
//        todoService.updateTodo(todo);
        todoRepository.save(todo);
        return todo;
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo)
    {
        /*Todo createdTodo =  todoService.addTodo(username, todo.getDescription(),
                                                todo.getTargetDate(), todo.isDone());
        return createdTodo;*/

        todo.setUsername(username);
        todo.setId(null);
        return todoRepository.save(todo);

    }
}
