package com.itany.nmms.entity;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.user_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.user_name
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.login_name
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private String loginName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.password
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.phone
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.address
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.is_valid
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private Integer isValid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.regist_date
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private Date registDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.user_id
     *
     * @return the value of sys_user.user_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.user_id
     *
     * @param userId the value for sys_user.user_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.user_name
     *
     * @return the value of sys_user.user_name
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.user_name
     *
     * @param userName the value for sys_user.user_name
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.login_name
     *
     * @return the value of sys_user.login_name
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.login_name
     *
     * @param loginName the value for sys_user.login_name
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.password
     *
     * @return the value of sys_user.password
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.password
     *
     * @param password the value for sys_user.password
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.phone
     *
     * @return the value of sys_user.phone
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.phone
     *
     * @param phone the value for sys_user.phone
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.address
     *
     * @return the value of sys_user.address
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.address
     *
     * @param address the value for sys_user.address
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.is_valid
     *
     * @return the value of sys_user.is_valid
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public Integer getIsValid() {
        return isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.is_valid
     *
     * @param isValid the value for sys_user.is_valid
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.regist_date
     *
     * @return the value of sys_user.regist_date
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public Date getRegistDate() {
        return registDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.regist_date
     *
     * @param registDate the value for sys_user.regist_date
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }
}