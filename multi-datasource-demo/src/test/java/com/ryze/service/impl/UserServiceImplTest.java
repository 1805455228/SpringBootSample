package test.com.ryze.service.impl;

import com.ryze.domain.User;
import com.ryze.mapper.UserMapper;
import com.ryze.service.UserService;
import com.ryze.util.IdWorker;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 12, 2019</pre>
 */
// ��ȡ�����࣬�������ã�ȷ��װ�� Spring �����װ�ط���������ȥѰ�� �����������ࣨ�� @SpringBootApplication ע��ģ�
@SpringBootTest(classes = com.ryze.DemoTest.class)
// �� JUnit ���� Spring �Ĳ��Ի����� ��� Spring �����������ĵ�֧��
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    /**
     * ����:DruidDataSource   : create connection SQLException, url: null, errorCode 0, state 08001
     * �޸�jdbc:mysql://localhost:3306/springboot1
     * ->jdbc:mysql://localhost:3306/springboot1?characterEncoding=UTF-8&useUnicode=true&useSSL=true&serverTimezone=UTC
     */
    @Resource
    private UserService userService;
    @Autowired
    private IdWorker idWorker;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: insert(User user)
     */
    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setId(Long.valueOf(idWorker.nextId()));
        user.setUserName("zhangsan1");
        user.setNickName("zhangsan1");
        user.setEmail("11@qq.com");
        user.setPassWord("123456");
        user.setRegTime(new Date().toString());
        userService.insert(user);
    }

    /**
     * Method: findAll()
     */
    @Test
    public void testFindAll() throws Exception {
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println("testFindAll:===>user=" + user);
        }
    }

    /**
     * Method: update(User user)
     */
    @Test
    public void testUpdate() throws Exception {

    }

    /**
     * Method: delete(Long id)
     */
    @Test
    public void testDelete() throws Exception {

    }


} 
