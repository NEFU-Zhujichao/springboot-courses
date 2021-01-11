package com.example.springbootjpaexample.example04;

import com.example.springbootjpaexample.example04.manytomany.Course04;
import com.example.springbootjpaexample.example04.manytomany.Elective;
import com.example.springbootjpaexample.example04.manytomany.Student04;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class ManyToManyTest {
    @Autowired
    private EntityManager manager;
    @Test
    public void test_init() {
        Course04 course = new Course04();
        course.setName("Web系统框架");
        manager.persist(course);
        Student04 student = new Student04();
        student.setName("chao");
        manager.persist(student);
        Student04 student2 = new Student04();
        student2.setName("qi");
        manager.persist(student2);
    }
    @Test
    public void test_rel1() {
        Course04 course = manager.find(Course04.class,3);
        Student04 student = manager.find(Student04.class,5);
        Student04 student2 = manager.find(Student04.class,6);
        Elective elective = new Elective();
        elective.setCourse(course);
        elective.setStudent(student);
        manager.persist(elective);
        Elective elective2 = new Elective();
        elective2.setCourse(course);
        elective2.setStudent(student2);
        manager.persist(elective2);
    }
}
