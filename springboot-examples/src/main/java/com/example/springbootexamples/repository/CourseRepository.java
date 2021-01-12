package com.example.springbootexamples.repository;

import com.example.springbootexamples.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends BaseRepository<Course,Integer>{

    @Query("from Course c where c.id=:cid and c.teacher.id=:tid")
    Course find(@Param("cid") Integer cid,@Param("tid") Integer tid);
}
