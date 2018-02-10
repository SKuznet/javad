package io.khasang.demo.model.impl;

import io.khasang.demo.model.Message;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("message")
public class MessageImpl implements Message {
    private String info;

    public MessageImpl() {
    }

    public MessageImpl(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @PostConstruct
    public void infoFill(){
        setInfo("Param");
    }

    @PreDestroy
    public void infoClean(){
        setInfo("");
    }
}
