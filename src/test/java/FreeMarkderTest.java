import com.yue.demo.service.HtmlService;
import com.yue.utils.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.io.File;

/**
 * Created by lms on 16-6-26.
 */
@TransactionConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:spring-mvc.xml"})
public class FreeMarkderTest {
    @Autowired
    private HtmlService htmlService;

    @Test
    public  void generateHtml(){
        String msg = "file.ftl";
        try {
            String content = htmlService.all(msg);
            if (!StringUtils.isEmpty(content)){
                String javaPath = new File("").getAbsolutePath() + "/src/main/java" + "/com/yue/demo/freeMarkerResult";
                String jspPath =new File("").getAbsolutePath() + "/src/main/webapp/WEB-INF" + "/views/auth";

                String fileName = "aaa.html";
                System.out.println("javaPath="+javaPath);
                System.out.println("jspPath="+jspPath);
                htmlService.writeResult(javaPath,fileName, content);
                htmlService.writeResult(jspPath,fileName,content);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testPath(){
        //取得根目录路径
        String rootPath=getClass().getResource("/").getFile().toString();
        System.out.println(rootPath);
        //当前目录路径
        String currentPath1=getClass().getResource(".").getFile().toString();
        System.out.println(currentPath1);
        String currentPath2=getClass().getResource("").getFile().toString();
        System.out.println(currentPath2);
        System.out.println(new File("").getAbsolutePath()+"/src/main/java"+"/com/yue/demo/freeMarkerResult/aaa.html");


    }
}
