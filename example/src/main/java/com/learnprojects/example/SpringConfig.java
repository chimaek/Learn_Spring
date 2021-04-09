package com.learnprojects.example;


import com.learnprojects.example.Repositories.*;
import com.learnprojects.example.Service.MemberService;
import com.learnprojects.example.aop.TimeTraceAop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig
{
    private final MemberRepo memberRepo;

    @Autowired
    public SpringConfig(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepo);
    }

//    @Bean
//    public MemberRepo repo(){
//
////        return new JpaMemberRepo(em);
//    }

}
