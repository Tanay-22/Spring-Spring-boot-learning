/*
package com.tanay.learnjpaandhibernate.course.jdbc;

import com.tanay.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner
{
    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception
    {
        repository.insert(new Course(1, "Learn DogeCoin Trading", "DogRaj ji"));
        repository.insert(new Course(2, "Doge Warrior", "Panther ji"));
        repository.insert(new Course(3, "Sprimg Boomt", "Kaalu ji"));

        repository.deleteById(1);

        System.out.println(repository.findById(3));
        System.out.println(repository.findById(2));
    }
}
*/
