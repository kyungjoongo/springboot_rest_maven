package com.kyungjoon.rest001.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDao {

    @Autowired
    private JdbcTemplate template;

    /**
     * Get hello list, using BeanPropertyRowMapper
     *
     * @return
     */
    public List<?> getList() {

        List arrList  = template.queryForList("SELECT * FROM blogs");
        return arrList;
    }

    /**
     * Insert hello
     *
     * @param hello
     * @return
     */
    public int insert(Hello hello) {
        String query = "INSERT INTO blogs(content) VALUES( ?)";
        return template.update(query, hello.getName());
    }
}