package com.tanay.todoapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
// store model attributes in the HTTP Servlet session between requests
// This typically lists the names of model attributes or types of model
// attributes that should be transparently stored in the session for
// subsequent requests to access.
public class TodoController
{
    private TodoService todoService;
    private TodoRepository todoRepository;

    public TodoController(TodoService todoService, TodoRepository todoRepository)
    {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String getLoggedInUsername(ModelMap modelMap)
    {
        String username = (String)modelMap.get("name");
        List<Todo> todos =  todoService.findByUsername(username);
        modelMap.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap modelMap)
    {
        String username = (String) modelMap.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now(), false);
        modelMap.put("todo", todo);
        return "newTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(@Valid Todo todo, BindingResult result, ModelMap modelMap)
    {
        /*the BindingResult parameter (result) is placed immediately after the
        @Valid annotated parameter (Todo todo) in your controller method signature.*/

        if(result.hasErrors())
            return "newTodo";

        String username = (String) modelMap.get("name");
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate());
        return "listTodos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id)
    {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap modelMap)
    {
        Todo todo = todoService.findById(id);
        modelMap.addAttribute("todo", todo);
        return "newTodo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap modelMap)
    {
        /*the BindingResult parameter (result) is placed immediately after the
        @Valid annotated parameter (Todo todo) in your controller method signature.*/

        if(result.hasErrors())
            return "newTodo";

        String username = (String) modelMap.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
