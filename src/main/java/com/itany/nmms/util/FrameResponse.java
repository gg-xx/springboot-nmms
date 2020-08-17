package com.itany.nmms.util;

import java.util.HashMap;

public class FrameResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = 6769157532172136264L;

    public FrameResponse() {
        // 继承HashMap<String, Object>的实例化.否则有可可能返回为空
        super();
    }

    public FrameResponse(int code, String message, Long count, Object data) {
        super();
        this.put("status", true);
        this.put("code", code);
        this.put("message", message);
        this.put("count", count);
        this.put("data", data);
    }

    /*
     * 重写put 并且返回自身实现链式
     */
    public FrameResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /*
     * del 删除某个键 并且返回自身实现链式
     */
    public FrameResponse del(String key) {
        super.remove(key);
        return this;
    }

    public static FrameResponse success() {
        return new FrameResponse(0, "", 0L, null);
    }

    public static FrameResponse success(String message) {
        return new FrameResponse(0, message, 0L, null);
    }

    public static FrameResponse success(Object data) {
        return new FrameResponse(0, "", 0L, data);
    }

    public static FrameResponse success(Object data, Long count) {
        return new FrameResponse(0, "", count, data);
    }

    public static FrameResponse success(int code, Object data) {
        return new FrameResponse(code, "", 0L, data);
    }
    public static FrameResponse success(int code, String message) {
        return new FrameResponse(code, message, 0L, null);
    }

    public static FrameResponse failure(String message) {
        return new FrameResponse(90000, message, 0L, null);
    }

    public static FrameResponse failure(int code, String message) {
        return new FrameResponse(code, message, 0L, null);
    }

    public static FrameResponse failure(int code, String message, Object data) {
        return new FrameResponse(code, message, 0L, data);
    }
}
