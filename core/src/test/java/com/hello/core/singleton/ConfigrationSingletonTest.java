package com.hello.core.singleton;

import com.hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigrationSingletonTest {


    @Test
    void configrationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig app = ac.getBean(AppConfig.class);

        System.out.println(app.getClass());
    }
}
