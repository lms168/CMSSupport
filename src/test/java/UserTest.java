import com.yue.auth.bean.User;
import com.yue.auth.service.AuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;

/**
 * Created by lms on 16-6-26.
 */
@TransactionConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserTest {
    @Resource(name="authService")
    private AuthService authService;

    @Test
    public void addUser(){
        User user = new User();
        user.setUsername("lsssss");
        user.setLoginName("ls");
        user.setPassword("123456");
        authService.saveUser(user);
        System.out.println("添加用户成功了");
    }

    @Test
    public void findUser(){
        User user = (User) authService.findUserById(1);
        if (user!=null)
        System.out.println(user.getId()+"===="+user.getUsername()+"=="+user.getPassword());

    }

    @Test
    public void findAllUser(){
        Pageable pageable = new PageRequest(0,20);
        Page<User> userPage = authService.findAll(pageable);
        for(User user:userPage.getContent()){
            System.out.println("userId="+user.getId()+",loginName="+user.getLoginName());
        }
        System.out.print(userPage.getTotalElements());
    }


}

