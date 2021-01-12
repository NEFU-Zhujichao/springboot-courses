package com.example.springbootexamples.repository;

import com.example.springbootexamples.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher, Integer> {
}
