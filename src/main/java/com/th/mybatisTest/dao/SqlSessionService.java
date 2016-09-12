package com.th.mybatisTest.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tianhui on 16/9/4.
 */
public class SqlSessionService {

    private static final String RESOURCE="mybatis/mybatis.xml";

    public static SqlSession getSqlSessionFactory() throws IOException {
        SqlSession sqlSession;
        InputStream resourceAsStream = Resources.getResourceAsStream(RESOURCE);
        sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        return sqlSession;
    }

    public static void closeSession(SqlSession sqlSession) {
        sqlSession.close();
    }
}
