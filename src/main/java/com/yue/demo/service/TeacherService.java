package com.yue.demo.service;

import com.yue.demo.entity.Teacher;
import com.yue.demo.repository.TeacherRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lms on 16-6-26.
 */
@Service("teacherService")
public class TeacherService {
    @Autowired
    private TeacherRpository teacherRpository;
    public void saveTeacher(Teacher teacher){
        teacherRpository.save(teacher);
    }

    public void deleteTeacher(Long id){
        teacherRpository.delete(id);
    }
}
