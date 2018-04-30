package com.example.administration.Static;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * <link>http://www.codejava.net/frameworks/spring/spring-mvc-with-jdbctemplate-example</link>
 */
public class DAOConfig
{
    private DriverManagerDataSource dataSource = new DriverManagerDataSource();

    public DataSource getDataSource() {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/StudentAdministration");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }
}
