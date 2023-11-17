package com.example.young.model;

public class CommonResult {
    private boolean result = true;
    private String message = "정상적으로 수행되었습니다.";

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
