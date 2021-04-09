package com.learnprojects.example;


import com.learnprojects.example.Repositories.*;
import com.learnprojects.example.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig
{
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(repo());
    }

    @Bean
    public MemberRepo repo(){
        return new JpaMemberRepo(em);
    }
}
