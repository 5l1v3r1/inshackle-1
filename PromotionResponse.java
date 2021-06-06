package com.kubernet.followers.Models;

import p076b.p109c.p223c.p224b0.C3094b;

public class PromotionResponse {
    @C3094b("credit")
    private Integer credit;
    @C3094b("message")
    private String message;
    @C3094b("status")
    private String status;

    public Integer getCredit() {
        return this.credit;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStatus() {
        return this.status;
    }

    public void setCredit(Integer num) {
        this.credit = 100000;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
