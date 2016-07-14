package com.yue.demo.entity;

import com.yue.common.IdEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lms on 16-6-26.
 */
@Entity
@Table(name="teacher")
public class Teacher extends IdEntity {

    private String name;
    private int age;

    @OneToMany(mappedBy = "teacher")  //如果不添加mapper字段，将会生成三张表
    private Set<Student> studentSet = new HashSet<Student>();

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

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
