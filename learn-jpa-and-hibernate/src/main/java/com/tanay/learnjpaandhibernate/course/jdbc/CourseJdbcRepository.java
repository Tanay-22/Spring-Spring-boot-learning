package com.tanay.learnjpaandhibernate.course.jdbc;

import com.tanay.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository
{
    private static String INSERT_QUERY =
            """
                    insert into course (id, name, author)
                    values(?, ?, ?);
            """;
    private static String DELETE_QUERY =
            """
                    delete from course
                    where id = ?;
            """;
    private static String SELECT_QUERY =
            """
                    select * from course
                    where id = ?
            """;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Course course)
    {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id)
    {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id)
    {
        return jdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);

        /*new BeanPropertyRowMapper<>(Course.class): This parameter specifies
        how the rows returned by the SQL query should be mapped to Java objects.
        BeanPropertyRowMapper is a Spring class that maps column values of a ResultSet
        to properties of a Java bean*

        Course class need to have getter methods for BeanPropertyRowMapper to access those
        properties using reflection
         */
    }
}
