package com.hello.core.beanFind;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class AppContextExtendsTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    void findBeanByParentType() {
//        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    void findBeanByParentTypeBeanName() {
        DiscountPolicy rate = ac.getBean("rate", DiscountPolicy.class);

        org.assertj.core.api.Assertions.assertThat(rate).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    void FindBeanBySubType() {
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    void findBeanByAllParentType() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);

    }

    @Test
    void FindBeanByObject() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);

        for (String key : beansOfType.keySet()) {
            System.out.println(key + "        " + beansOfType.get(key));
        }

    }


    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rate() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fix() {
            return new FixDiscountPolicy();
        }
    }
}
