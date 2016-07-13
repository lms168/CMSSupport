import com.yue.base.entity.Student;
import com.yue.base.service.StudentService;
import com.yue.base.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by lms on 16-6-26.
 */
@TransactionConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class StudentTest {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;


    @Test
    public void saveStudent(){
        Student student = new Student();
        student.setName("aa");
        student.setAge(11);

//        Teacher teacher = new Teacher();
//        teacher.setName("lw");
//        teacher.setAge(111);
//
//        student.setTeacher(teacher); /teacher/表示由student端来维护关系
//        //teacherService.saveTeacher(teacher);
//
//        teacherService.saveTeacher(teacher);
        studentService.saveStudent(student);


        System.out.println("添加用户成功了");
    }



    @Test
    public void updateStudent(){
        Student student =studentService.findById(8l);
        student.setName("bbb");
        studentService.saveStudent(student);

    }



    @Test
    public void deleteTeacher(){
        teacherService.deleteTeacher(7l);
    }

}

