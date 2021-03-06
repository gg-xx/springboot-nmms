package com.itany.nmms.entity;

import java.util.Date;

public class Dept {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dept.dept_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private Integer deptId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dept.dept_name
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private String deptName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dept.dept_no
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private String deptNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dept.father_dept_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private Integer fatherDeptId;

    private Dept dept;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dept.remark
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dept.create_date
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dept.create_staff_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private Integer createStaffId;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    private Staff staff;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dept.is_valid
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    private Integer isValid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dept.dept_id
     *
     * @return the value of sys_dept.dept_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dept.dept_id
     *
     * @param deptId the value for sys_dept.dept_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dept.dept_name
     *
     * @return the value of sys_dept.dept_name
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dept.dept_name
     *
     * @param deptName the value for sys_dept.dept_name
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dept.dept_no
     *
     * @return the value of sys_dept.dept_no
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public String getDeptNo() {
        return deptNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dept.dept_no
     *
     * @param deptNo the value for sys_dept.dept_no
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo == null ? null : deptNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dept.father_dept_id
     *
     * @return the value of sys_dept.father_dept_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public Integer getFatherDeptId() {
        return fatherDeptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dept.father_dept_id
     *
     * @param fatherDeptId the value for sys_dept.father_dept_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setFatherDeptId(Integer fatherDeptId) {
        this.fatherDeptId = fatherDeptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dept.remark
     *
     * @return the value of sys_dept.remark
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dept.remark
     *
     * @param remark the value for sys_dept.remark
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dept.create_date
     *
     * @return the value of sys_dept.create_date
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dept.create_date
     *
     * @param createDate the value for sys_dept.create_date
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dept.create_staff_id
     *
     * @return the value of sys_dept.create_staff_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public Integer getCreateStaffId() {
        return createStaffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dept.create_staff_id
     *
     * @param createStaffId the value for sys_dept.create_staff_id
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setCreateStaffId(Integer createStaffId) {
        this.createStaffId = createStaffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dept.is_valid
     *
     * @return the value of sys_dept.is_valid
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public Integer getIsValid() {
        return isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dept.is_valid
     *
     * @param isValid the value for sys_dept.is_valid
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}