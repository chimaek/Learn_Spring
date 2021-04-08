package com.learnprojects.example.repository;

import com.learnprojects.example.Domain.Member;
import com.learnprojects.example.Repositories.MemoryMemberRepo;

import org.junit.jupiter.api.AfterEach;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMeberRepoTest {
    MemoryMemberRepo memoryMemberRepo = new MemoryMemberRepo();

    @AfterEach
    public void afterEach(){
        memoryMemberRepo.clear();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        memoryMemberRepo.save(member);
        Member result = memoryMemberRepo.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepo.save(member2);

        Member result2= memoryMemberRepo.findByName("spring1").get();
        assertThat(member1).isEqualTo(result2);
    }

    @Test
    public void findAll(){
        List<Member> allmember = new ArrayList<>();
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepo.save(member2);
        allmember.add(member1);
        allmember.add(member2);

        List<Member> result3 = memoryMemberRepo.findAll();

        assertThat(allmember).isEqualTo(result3);
    }
}
