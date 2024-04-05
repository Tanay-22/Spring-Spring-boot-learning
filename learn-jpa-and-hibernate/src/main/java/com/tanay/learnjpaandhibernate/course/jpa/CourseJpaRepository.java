package com.tanay.learnjpaandhibernate.course.jpa;

import com.tanay.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository
{
    //used to mark a field, property, or setter method of a
    // managed bean as a JPA EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course)
    {
        entityManager.merge(course);
    }

    public Course findById(long id)
    {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id)
    {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
