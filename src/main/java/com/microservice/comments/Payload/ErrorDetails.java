package com.microservice.comments.Payload;

import java.util.Date;

public class ErrorDetails {

    private Date date;
    private String mssg;
    private String request;

    public ErrorDetails(Date date, String mssg, String request) {
        this.date = date;
        this.mssg = mssg;
        this.request = request;
    }

    public Date getDate() {
        return date;
    }

    public String getMssg() {
        return mssg;
    }

    public String getRequest() {
        return request;
    }
}
