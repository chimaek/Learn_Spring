package com.hello.core;

import com.sun.jdi.PathSearchingVirtualMachine;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
    }




}
