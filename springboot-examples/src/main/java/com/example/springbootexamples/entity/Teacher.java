package com.example.springbootexamples.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
//注解在类上时：序列化和反序列化都忽略，能忽略多个属性(在many端全部断开)
//注解在属性上时：序列化和反序列化都忽略，能忽略多个属性(不好维护)
//eg：@JsonIgnoreProperties({"teacher"})
//    private List<Course> courses;
//会序列化courses 但是每一个course中的teacher不会序列化，所以不会产生循环
//@JsonIgnore 注解在属性上序列化和反序列化时忽略(指定属性)
@JsonIgnoreProperties({"courses","students"})
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @MapsId
    private User user;
    private Integer quantity;
    private Integer ranges;
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
    @OneToMany(mappedBy = "teacher")
    private List<Student> students;
    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime insertTime;

    public Teacher(Integer id) {
        this.id = id;
    }
}
