package com.hello.core.xml;

import com.hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlContext {

    @Test
    void xmlContext(){
        GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext("appConfig.xml");

        MemberService memberService = genericXmlApplicationContext.getBean("memberService",MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
