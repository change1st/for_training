package mybatisTest.dao;

import com.alibaba.fastjson.JSON;
import com.th.mybatisTest.dao.SqlSessionService;
import com.th.mybatisTest.dao.UserMapper;
import com.th.mybatisTest.po.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tianhui on 16/9/4.
 */
public class UserMapperTest {

    private final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    private UserMapper userMapper;

    private SqlSession sqlSession = SqlSessionService.getSqlSessionFactory();

    @Before
    public void init() throws SQLException {
        sqlSession.getConnection().setAutoCommit(true);//设置自动提交
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    public UserMapperTest() throws IOException {
    }

    @Test
    public void getAllUser() throws Exception {
        List<User> allUser = userMapper.getAllUser();
        System.out.println(JSON.toJSONString(allUser));
        SqlSessionService.closeSession(sqlSession);
    }

    @Test
    public void insertUser() {
        try {
            User user = new User("jim", 20, "m", "三个人");
            userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insertUser(user);
//            sqlSession.commit();
        } catch (Exception e) {
            System.out.println("插入异常");
            sqlSession.rollback();
        } finally {
            SqlSessionService.closeSession(sqlSession);
        }

    }
}