package com.learnprojects.example.repository;

import com.learnprojects.example.Domain.Member;
import com.learnprojects.example.Repositories.MemoryMemberRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryMeberRepoTest {
    MemoryMemberRepo memoryMemberRepo = new MemoryMemberRepo();

    @AfterEach
    public void afterEach(){
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        memoryMemberRepo.save(member);
        Member result = memoryMemberRepo.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
}
