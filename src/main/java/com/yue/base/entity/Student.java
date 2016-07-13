package com.yue.base.entity;

import javax.persistence.*;

/**
 * Created by lms on 16-6-26.
 */
@Table(name="student")
@Entity
public class Student extends IdEntity {

    private String name;
    private int age;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher = new Teacher();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
