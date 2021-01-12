package com.example.springbootexamples.repository;

import com.example.springbootexamples.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<Student,Integer>{
    @Query("from Student s where s.user.name=:name and s.user.number=:num")
    Student find(@Param("name") String name, @Param("num") int num);
}
