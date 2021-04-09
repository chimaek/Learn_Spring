package com.learnprojects.example;


import com.learnprojects.example.Repositories.JdbcMemberRepo;
import com.learnprojects.example.Repositories.MemberRepo;
import com.learnprojects.example.Repositories.MemoryMemberRepo;
import com.learnprojects.example.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig
{
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource ds){
        dataSource = ds;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(repo());
    }

    @Bean
    public MemberRepo repo(){
        return new JdbcMemberRepo(dataSource);
    }
}
