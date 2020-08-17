package com.itany.nmms.service;

import com.itany.nmms.entity.Dept;
import com.itany.nmms.entity.Product;
import com.itany.nmms.exception.DeptExistException;
import com.itany.nmms.exception.DeptNotExistException;
import com.itany.nmms.exception.RequestParameterErrorException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

public interface DeptService {

    //Integer deptId;
    //String deptName;
    //String deptNo;
    //Integer fatherDeptId;
    //String remark;
    //Date createDate;
    //Integer createStaffId;
    //Integer isValid;

    void addDept(String deptName, String remark) throws RequestParameterErrorException, DeptExistException;

    List<Dept> findAll();

    Dept findById(String deptId) throws RequestParameterErrorException;

    void modifyDept(String deptId,String deptName, String remark) throws RequestParameterErrorException, DeptExistException;

    void remove(String deptId) throws RequestParameterErrorException, DeptExistException;

    void addZdept(String fDeptId, String zDeptName, String zRemark)throws RequestParameterErrorException, DeptExistException;

    void modifyStatus(String deptId) throws Exception;

    List<Dept> findEnable() throws DeptNotExistException;
}
