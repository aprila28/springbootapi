package com.alitv.springbootrest.model;

public class ResponseRegister{
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResponseRegister(String status) {
        this.status = status;
    }
}
