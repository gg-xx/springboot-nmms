package com.itany.nmms.util;

import java.io.Serializable;

public class ResponseResult implements Serializable {

    // 业务逻辑状态码
    private String responseCode;
    // 响应消息
    private String message;
    // 响应对象
    private Object returnObject;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }
}
