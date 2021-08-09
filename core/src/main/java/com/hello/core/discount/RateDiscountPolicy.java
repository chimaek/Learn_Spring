package com.hello.core.discount;

import com.hello.core.annotation.MainDiscountPolicy;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // 같은 빈이 있다면 이것이 우선순위를 가짐
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
    private int disocuntPer = 10;


    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * disocuntPer / 100;
        } else {
            return price;
        }

    }
}
