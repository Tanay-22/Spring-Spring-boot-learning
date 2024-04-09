package com.tanay.todoapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService
{
    private static int count = 1;
    private static List<Todo> todos = new ArrayList<>();
    static
    {
        todos.add(new Todo(count++, "DogRaj", "Conquering the world",
                LocalDate.now().plusYears(1), true));
        todos.add(new Todo(count++, "DogRaj", "Sleep",
                LocalDate.now().plusYears(3), false));
        todos.add(new Todo(count++, "DogRaj", "Eat",
                LocalDate.now().plusYears(5), false));
    }

    public List<Todo> findByUsername(String username)
    {
        return todos;
    }

    public Todo findById(int id)
    {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }
    public static void deleteById(int id)
    {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void addTodo(String username, String description, LocalDate date)
    {
        todos.add(new Todo(count++, username, description, date, false));
    }

    public void updateTodo(Todo todo)
    {

    }
}
