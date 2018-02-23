package com.studybook.between.config;

import com.studybook.between.auth.mapper.AuthMapper;
import com.studybook.between.file.mapper.FileMapper;
import com.studybook.between.post.mapper.PostMapper;
import com.studybook.between.user.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        SqlSessionFactory sqlSessionFactory = sessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().addMapper(AuthMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(PostMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(FileMapper.class);
        return sqlSessionFactory;
    }

    @Bean
    public AuthMapper authMapper() throws Exception {
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sessionTemplate.getMapper(AuthMapper.class);
    }

    @Bean
    public PostMapper postMapper() throws Exception {
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sessionTemplate.getMapper(PostMapper.class);
    }

    @Bean
    public UserMapper userMapper() throws Exception {
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sessionTemplate.getMapper(UserMapper.class);
    }

    @Bean
    public FileMapper fileMapper() throws Exception {
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sessionTemplate.getMapper(FileMapper.class);
    }

}