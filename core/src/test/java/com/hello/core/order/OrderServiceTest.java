package com.hello.core.order;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();


    @Test
    void createOrder(){
        Long id = 1L;

        Member member = new Member(id,"memberㅁㅁ", Grade.VIP);
        memberService.joinMember(member);

        Order order = orderService.createOrder(id,"item1",10000);

        assertThat(order.getItemPrice()).isEqualTo(10000);
    }
}
