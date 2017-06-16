package com.appbusters.robinkamboj.zailetapp.model;

import java.util.List;

public class topicsResponse {

    public topicsResponse(List<topics> result) {
        this.result = result;
    }

    private List<topics> result;

    public List<topics> getResult() {
        return result;
    }

    public void setResult(List<topics> result) {
        this.result = result;
    }

}
