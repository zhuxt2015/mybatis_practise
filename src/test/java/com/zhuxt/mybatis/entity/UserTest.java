package com.zhuxt.mybatis.entity;

import com.zhuxt.mybatis.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by zhuxt on 17/2/28.
 */
public class UserTest {

    @Test
    public void Test() {
        String resource = "mybatis.xml";
        //使用类加载器加载mybatis的配置文件,同时加载关联的配置文件
        InputStream inputStream = UserTest.class.getClassLoader().getResourceAsStream(resource);
        //sqlSessionFactory
        SqlSessionFactory sessionFactory = null;

        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //session
        SqlSession session = sessionFactory.openSession();

        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.getById(1);
        assertNull(user);
    }

}