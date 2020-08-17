package com.itany.nmms.service.impl;

import com.itany.nmms.constant.DictConstant;
import com.itany.nmms.constant.StatusConstant;
import com.itany.nmms.dao.StaffMapper;
import com.itany.nmms.entity.Staff;
import com.itany.nmms.entity.StaffExample;
import com.itany.nmms.exception.*;
import com.itany.nmms.service.StaffService;
import com.itany.nmms.util.MD5Util;
import com.itany.nmms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Staff login(String loginName, String password, String role, String code, String image) throws RequestParameterErrorException, CodeErrorException, StaffNotExistException {
        if(StringUtil.isNull(loginName) || StringUtil.isNull(password) || StringUtil.isNull(role) || StringUtil.isNull(code) || StringUtil.isNull(image)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        if(!image.equals(code)){
            throw new CodeErrorException("验证码不正确");
        }

        StaffExample example = new StaffExample();
        example.or()
                .andLoginNameEqualTo(loginName)
                .andPasswordEqualTo(MD5Util.md5(password))
                .andRoleEqualTo(role)
                .andIsValidEqualTo(StatusConstant.SYS_STAFF_IS_VALID_ENABLE);
        List<Staff> staffs = staffMapper.selectByExample(example);
        if(staffs.isEmpty()){
            throw new StaffNotExistException("账号或密码错误");
        }
        return staffs.get(0);
    }

    @Override
    public void addStaff(Staff staffParameter, Staff staff) throws LoginDisableException, NoPromissionException, StaffExistException, RequestParameterErrorException {
        if(StringUtil.isNull(staffParameter.getStaffName()) || StringUtil.isNull(staffParameter.getLoginName())|| StringUtil.isNull(staffParameter.getPhone())){
            throw new RequestParameterErrorException("请求参数有误");
        }
        if(staff == null){
            throw new LoginDisableException("登录失效,请重新登录");
        }

        if(staff.getRole() == DictConstant.SYS_STAFF_ROLE_COMMON_MANAGER){
            throw new NoPromissionException("权限不足,无法添加");
        }
        StaffExample example = new StaffExample();
        example.or()
                .andLoginNameEqualTo(staffParameter.getLoginName());
        List<Staff> staffs = staffMapper.selectByExample(example);
        if(!staffs.isEmpty()){
            throw new StaffExistException("该账号已经存在");
        }
        staffParameter.setPassword(MD5Util.md5(staffParameter.getPassword()));

        // 设置默认参数
        staffParameter.setIsValid(StatusConstant.SYS_STAFF_IS_VALID_ENABLE);
        // 创建时间
        staffParameter.setCreateDate(new Date());
        // 创建人
        staffParameter.setCreateStaffId(staff.getStaffId());

        staffMapper.insertSelective(staffParameter);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Staff> findByParams(Staff staffParameter) {
//        if(StringUtil.isNull(staffParameter.getStaffName()) || StringUtil.isNull(staffParameter.getLoginName())|| StringUtil.isNull(staffParameter.getPhone())){
//            throw new RequestParameterErrorException("请求参数有误");
//        }
        Staff staff = new Staff();
        staff.setStaffName(StringUtil.escapeString(staffParameter.getStaffName()));
        staff.setLoginName(StringUtil.escapeString(staffParameter.getLoginName()));
        staff.setPhone(StringUtil.escapeString(staffParameter.getPhone()));
        staff.setEmail(StringUtil.escapeString(staffParameter.getEmail()));
        staff.setDeptId(staffParameter.getDeptId());
        staff.setRole(staffParameter.getRole());
        staff.setIsValid(staffParameter.getIsValid());
        List<Staff> staffs = staffMapper.selectByParams(staff);
        return staffs.isEmpty()?null:staffs;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Staff findById(String id) throws RequestParameterErrorException {
        if(StringUtil.isNull(id)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        Staff staff = staffMapper.selectByPrimaryKey(Integer.parseInt(id));
        return staff;
    }

    @Override
    public void modifyStaff(Staff staffParameter) throws RequestParameterErrorException {
        if(staffParameter.getStaffId() == null || StringUtil.isNull(staffParameter.getStaffName()) || StringUtil.isNull(staffParameter.getPhone())){
            throw new RequestParameterErrorException("请求参数有误");
        }
        staffMapper.updateByPrimaryKeySelective(staffParameter);
    }

    @Override
    public void modifyStatus(String id) throws RequestParameterErrorException {
        if(StringUtil.isNull(id)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        Staff staff = staffMapper.selectByPrimaryKey(Integer.parseInt(id));
        if(staff.getIsValid() == StatusConstant.SYS_STAFF_IS_VALID_ENABLE){
            staff.setIsValid(StatusConstant.SYS_STAFF_IS_VALID_DISABLE);
        }else{
            staff.setIsValid(StatusConstant.SYS_STAFF_IS_VALID_ENABLE);
        }
        staffMapper.updateByPrimaryKeySelective(staff);
    }
}
