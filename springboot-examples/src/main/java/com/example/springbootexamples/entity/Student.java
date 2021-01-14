package com.example.springbootexamples.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@JsonIgnoreProperties({"teacher", "course"})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //级联增加和删除
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    //共用主键
    @MapsId
    private User user;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Course course;
    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime insertTime;
}
