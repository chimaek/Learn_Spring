package com.hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void protoTypeBeanfind() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SingtonBean.class);

        SingtonBean bean = ac.getBean(SingtonBean.class);
        SingtonBean bean1 = ac.getBean(SingtonBean.class);
//        Assertions.assertThat(bean).isSameAs(bean1);
        Assertions.assertThat(bean).isNotSameAs(bean1);
    }

    @Scope("prototype")
    static class SingtonBean {
        @PostConstruct
        public void init() {
            System.out.println("싱글톤생성성");
        }

        @PreDestroy
        public void destory() {
            System.out.println("빈 종료");
        }
    }
}
