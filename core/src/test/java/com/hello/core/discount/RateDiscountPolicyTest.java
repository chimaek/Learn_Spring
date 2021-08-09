package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Test
    @DisplayName("vip 10%할인")
    void vip_o(){

        //given
        Member member = new Member(1L, "vip", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member,10000);
        Assertions.assertThat(discount).isEqualTo(1000);
        //then
    }

    @Test
    @DisplayName("vip 10%노할인")
    void vip_x(){

        //given
        Member member = new Member(1L, "vip", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member,10000);
        Assertions.assertThat(discount).isEqualTo(10000);

        //then
    }

}