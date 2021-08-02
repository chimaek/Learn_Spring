package com.hello.core.member;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {

        //given
        Member member = new Member(1L, "asa12", Grade.VIP);


        //when
        memberService.joinMember(member);
        Member findMember = memberService.findMember(1L);


        assertThat(member).isEqualTo(findMember);

    }


}