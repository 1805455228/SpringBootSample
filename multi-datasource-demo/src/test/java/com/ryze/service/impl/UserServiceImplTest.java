package test.com.ryze.service.impl;

import com.ryze.domain.User;
import com.ryze.mapper.UserMapper;
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
    private UserMapper userMapper;
    @Autowired
    private  IdWorker idWorker;

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
        user.setUserName("zhangsan");
        user.setNickName("zhangsan");
        user.setEmail("1@qq.com");
        user.setPassWord("123456");
        user.setRegTime(new Date().toString());
        userMapper.insert(user)  ;
    }

    /**
     * Method: update(User user)
     */
    @Test
    public void testUpdate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delete(Long id)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAll()
     */
    @Test
    public void testFindAll() throws Exception {
        userMapper.findAll();
    }


} 
