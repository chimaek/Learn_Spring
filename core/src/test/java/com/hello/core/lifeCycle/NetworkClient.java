package com.hello.core.lifeCycle;

public class NetworkClient {


    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출" + url);
        connect();
        call("초기화 메세지");
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
}
