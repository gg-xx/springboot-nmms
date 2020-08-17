package com.itany.nmms.service;

import com.itany.nmms.entity.Staff;
import com.itany.nmms.exception.*;

import java.util.List;

public interface StaffService {

    /**
     * 员工登录
     * @param loginName
     * @param password
     * @param role
     * @param code
     * @param image
     * @return
     */
    public Staff login(String loginName, String password, String role, String code, String image) throws RequestParameterErrorException, CodeErrorException, StaffNotExistException;

    /**
     * 添加管理员
     * @param staffParameter
     * @param staff
     */
    public void addStaff(Staff staffParameter,Staff staff) throws LoginDisableException, NoPromissionException, StaffExistException, RequestParameterErrorException;


    /**
     * 根据给定的条件进行查询
     * @param staffParameter
     * @return
     */
    public List<Staff> findByParams(Staff staffParameter) ;

    /**
     * 修改设置默认值
     * @param id
     * @return
     */
    public Staff findById(String id) throws RequestParameterErrorException;

    /**
     * 修改功能
     * @param staffParameter
     */
    public void modifyStaff(Staff staffParameter) throws RequestParameterErrorException;

    /**
     * 启用与禁用
     * @param id
     */
    public void modifyStatus(String id) throws RequestParameterErrorException;
}
