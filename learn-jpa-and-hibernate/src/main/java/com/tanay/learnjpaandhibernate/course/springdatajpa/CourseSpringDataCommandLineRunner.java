package com.tanay.learnjpaandhibernate.course.springdatajpa;

import com.tanay.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringDataCommandLineRunner implements CommandLineRunner
{
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception
    {
        repository.save(new Course(1, "Learn DogeCoin Trading", "DogRaj ji"));
        repository.save(new Course(2, "Doge Warrior", "Panther ji"));
        repository.save(new Course(3, "Sprimg Boomt", "Kaalu ji"));

        repository.deleteById(1l);

        System.out.println(repository.findById(3l));
        System.out.println(repository.findById(2l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("Kaalu ji"));
    }
}

