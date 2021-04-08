package com.learnprojects.example;


import com.learnprojects.example.Repositories.MemoryMemberRepo;
import com.learnprojects.example.Service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig
{
    @Bean
    public MemberService memberService(){
        return new MemberService(repo());
    }

    @Bean
    public MemoryMemberRepo repo(){
        return new MemoryMemberRepo();
    }
}
