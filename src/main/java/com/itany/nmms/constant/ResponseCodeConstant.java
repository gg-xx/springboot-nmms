package com.itany.nmms.constant;

public interface ResponseCodeConstant {

    /**
     * 业务逻辑状态码:成功
     */
    public static final String RESPONSE_CODE_SUCCESS = "2001";

    /**
     * 业务逻辑状态码:失败
     */
    public static final String RESPONSE_CODE_FAIL = "2002";

    /**
     * 业务逻辑状态码:请求参数有误
     */
    public static final String RESPONSE_CODE_REQUEST_PARAMETER_ERROR = "2003";

    /**
     * 业务逻辑状态码:登录超时
     */
    public static final String RESPONSE_CODE_LOGIN_TIMEOUT = "2004";

    /**
     * 业务逻辑状态码:权限不足
     */
    public static final String RESPONSE_CODE_NO_PROMISSION = "2005";


}
