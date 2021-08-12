package com.hello.core.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출" + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect" + url);
    }

    public void call(String name) {
        System.out.println("call : " + url + "message : " + name);
    }

    public void close() {
        System.out.println("종료료");
    }

    @PreDestroy
    public void destroy() throws Exception {
        close();
    }

    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화 메세지");
    }
}
