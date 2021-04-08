package com.learnprojects.example.Service;

import com.learnprojects.example.Domain.Member;
import com.learnprojects.example.Repositories.MemberRepo;
import com.learnprojects.example.Repositories.MemoryMemberRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepo memberRepo;

    @BeforeEach
    public void beforeEach(){
        memberRepo = new MemoryMemberRepo();
        memberService= new MemberService(memberRepo);
    }

    @AfterEach
    public void can(){
        memberRepo.clear();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void can_regi() {
        //given
        Member member1 = new Member();
        member1.setName("spring!");
        Member member2 = new Member();
        member2.setName("spring!");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //memberService.join(member2);


        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}