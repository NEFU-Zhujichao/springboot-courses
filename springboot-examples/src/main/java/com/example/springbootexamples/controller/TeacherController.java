package com.example.springbootexamples.controller;

import com.example.springbootexamples.component.MyToken;
import com.example.springbootexamples.component.RequestComponent;
import com.example.springbootexamples.entity.Course;
import com.example.springbootexamples.entity.Student;
import com.example.springbootexamples.entity.Teacher;
import com.example.springbootexamples.service.CourseService;
import com.example.springbootexamples.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api/teacher/")
public class TeacherController {
    @Autowired
    private RequestComponent requestComponent;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;

    @GetMapping("welcome")
    public void  getIndex(HttpServletRequest request, @RequestAttribute(MyToken.UID) int uid){
        log.debug("{}", (int)request.getAttribute(MyToken.UID));
        log.debug("{}", uid);
        log.debug("{}", requestComponent.getUid());
    }

    @GetMapping("index")
    public Map getTeacher() {
        Teacher t = userService.getTeacher(requestComponent.getUid());
        return Map.of(
                "teacher", t,
                "courses", t.getCourses(),
                "students", t.getStudents());
    }

    @PostMapping("courses")
    public Map postCourse(@RequestBody Course course) {
        course.setTeacher(new Teacher(requestComponent.getUid()));
        courseService.addCourse(course);
        return Map.of("course", course);
    }

    @GetMapping("courses/{cid}")
    public Map getCourse(@PathVariable int cid) {
        return Map.of("course", courseService.getCourse(cid, requestComponent.getUid()));
    }

    @PatchMapping("settings")
    public Map patchSettings(@RequestBody Teacher t) {
        Teacher teacher = userService.updateTeacher(t.getQuantity(), t.getRanges(), requestComponent.getUid());
        return Map.of("teacher", teacher);
    }

    @PostMapping("students")
    public Map postStudent(@RequestBody Student s) {
        Student student = courseService.addStudent(s, requestComponent.getUid());
        return Map.of("student", s);
    }
}
