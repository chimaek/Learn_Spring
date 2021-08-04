package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.order.Order;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long id = 4L;
        Member member = new Member(id, "me", Grade.VIP);
        memberService.joinMember(member);

        Order tiem1 = orderService.createOrder(id, "tiem1", 10000);

        System.out.println(tiem1);

    }
}
