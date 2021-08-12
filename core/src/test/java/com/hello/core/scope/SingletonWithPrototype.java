package com.hello.core.scope;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;
import java.security.PublicKey;

public class SingletonWithPrototype {


    @Test
    void prototypeFind() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean = ac.getBean(PrototypeBean.class);
        bean.addCount();
        Assertions.assertThat(bean.getCount()).isEqualTo(1);

        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);

        bean1.addCount();

        Assertions.assertThat(bean1.getCount()).isEqualTo(1);

    }

    @Test
    void singletonClientUsePrototype() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean bean1 = ac.getBean(ClientBean.class);
        int count1 = bean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean bean2 = ac.getBean(ClientBean.class);
        int count2 = bean1.logic();
        Assertions.assertThat(count2 ).isEqualTo(1);
    }

//    @RequiredArgsConstructor
//    static class ClientBean {
//        private final PrototypeBean prototypeBean;
//
//        public int logic() {
//            prototypeBean.addCount();
//            return prototypeBean.getCount();
//        }
//
//    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println(this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("disconnect " + this);
        }
    }

//    @Scope("singleton")
//    static class ClientBean {
//        @Autowired
//        private ObjectProvider<PrototypeBean> prototypeProvider;
//
//        public int logic() {
//            PrototypeBean bean = prototypeProvider.getObject();
//            bean.addCount();
//            int count = bean.getCount();
//            return count;
//        }
//
//    }

    @Scope("singleton")
    static class ClientBean {
        @Autowired
        private ObjectProvider<PrototypeBean> prototypeProvider;

        public int logic() {
            PrototypeBean bean = prototypeProvider.getObject();
            bean.addCount();
            int count = bean.getCount();
            return count;
        }

    }
}
