package com.example.demo2sql.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.spec.NamedParameterSpec;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MyRepository {
    final static String scriptFileName = "3dz.sql";
    private String products;
    private NamedParameterJdbcTemplate template;

    @Autowired
    public MyRepository(NamedParameterJdbcTemplate template){
        this.template = template;
        products = read(scriptFileName);
    }
    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name){
        return template.queryForList(products,new MapSqlParameterSource("name", name), String.class);
    }
}
