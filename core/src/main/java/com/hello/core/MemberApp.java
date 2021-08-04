package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L,"em", Grade.VIP);
        memberService.joinMember(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(findMember.getGrade());
        System.out.println(findMember.getName());
    }
}
