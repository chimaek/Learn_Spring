package com.hello.core.beanFind;

import com.hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            System.out.println((Object) ac.getBean(bean));
        }
    }

    @Test
    void findAppBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(bean);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println((Object) ac.getBean(bean));
            }
        }
    }
}
