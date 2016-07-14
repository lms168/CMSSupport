package com.yue.demo.repository;

import com.yue.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lms on 16-6-26.
 */
public interface TeacherRpository extends JpaRepository<Teacher,Long>{
}
