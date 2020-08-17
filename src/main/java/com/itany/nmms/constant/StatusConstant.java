package com.itany.nmms.constant;

public interface StatusConstant {

    /**
     *  员工在职
     */
    public static final int SYS_STAFF_IS_VALID_ENABLE = 1;

    /**
     *  员工离职
     */
    public static final int SYS_STAFF_IS_VALID_DISABLE = 0;

    /**
     * 商品类型状态为启用
     */
    public static final int SYS_PRODUCT_TYPE_STATUS_ENABLE = 1;

    /**
     * 商品类型状态为禁用
     */
    public static final int SYS_PRODUCT_TYPE_STATUS_DISABLE = 0;

    /**
     * 部门状态，默认启用为1
     */
    public static final int SYS_DEPT_TYPE_STATUS_ENABLE = 1;

    /**
     * 部门状态，禁用为0
     */
    public static final int SYS_DEPT_TYPE_STATUS_DISABLE = 0;
}
