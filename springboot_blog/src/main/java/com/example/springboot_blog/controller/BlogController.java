package com.example.springboot_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Controller
public class BlogController {
    @Autowired
    DataSource source;

    @GetMapping("/test")
    public String home() {
//        Connection connection = source.getConnection();
//        DatabaseMetaData databaseMetaData = connection.getMetaData();
//        return "<h1>"+databaseMetaData.getDriverName()+databaseMetaData.getUserName()+databaseMetaData.getURL()+"</h1>";
        return "test";
    }

}
