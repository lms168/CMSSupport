package com.yue.base.service;

import com.yue.base.entity.Student;
import com.yue.base.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lms on 16-6-26.
 */
@Service("studentService")
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student student){
        studentRepository.save(student);
    }


    public Student findById(Long id){
      return  studentRepository.findOne(id);
    }
}
