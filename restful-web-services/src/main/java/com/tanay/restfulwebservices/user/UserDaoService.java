package com.tanay.restfulwebservices.user;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService
{
    // DAO - data access object

    private static List<User> users = new ArrayList<>();
    private static int count = 1;

    static
    {
        users.add(new User(count++,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(count++,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(count++,"Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll()
    {
        return users;
    }

    public User findOne(int id)
    {
        Predicate<User> userPredicate = user -> user.getId() == id;
        return users.stream().filter(userPredicate).findFirst().orElse(null);
    }

    public User save(User user)
    {
        user.setId(count++);
        users.add(user);
        return user;
    }

    public void deleteById(int id)
    {
        Predicate<User> userPredicate = user -> user.getId() == id;
        users.removeIf(userPredicate);
    }
}
