package com.hello.core.singleton;

import com.hello.core.AppConfig;
import com.hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링없는 순수한 di컨테이너 테스트")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();

        MemberService memberService1 = appConfig.memberService();

        System.out.println(memberService);
        System.out.println(memberService1);

        Assertions.assertThat(memberService).isNotSameAs(memberService1);
    }

    @Test
    void singletonServiceTest(){
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance1 = SingletonService.getInstance();

        Assertions.assertThat(instance).isSameAs(instance1);
    }

    @Test
    void SingleTonContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService",MemberService.class);

        MemberService memberService1 = ac.getBean("memberService",MemberService.class);

        System.out.println(memberService);
        System.out.println(memberService1);

        Assertions.assertThat(memberService).isSameAs(memberService1);
        System.out.println();
    }
}
