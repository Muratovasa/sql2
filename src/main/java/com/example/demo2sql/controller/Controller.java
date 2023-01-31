package com.example.demo2sql.controller;

import com.example.demo2sql.repository.MyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final MyRepository repository;

    public Controller(MyRepository repository){
        this.repository=repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getListProdName(String name){
        return repository.getProductName(name);
    }
}
