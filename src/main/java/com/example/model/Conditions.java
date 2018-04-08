package com.example.model;

import java.util.Date;

public class Conditions {
    private String ip;
    private String app;  //手机端
    private String client; //客户端

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Conditions{" +
                "ip='" + ip + '\'' +
                ", app='" + app + '\'' +
                ", client='" + client + '\'' +
                '}';
    }
}
