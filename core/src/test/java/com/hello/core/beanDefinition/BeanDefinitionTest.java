package com.hello.core.beanDefinition;

import com.hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void FindAppicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String gs : beanDefinitionNames){
            BeanDefinition bf = ac.getBeanDefinition(gs);
        }
    }
}
