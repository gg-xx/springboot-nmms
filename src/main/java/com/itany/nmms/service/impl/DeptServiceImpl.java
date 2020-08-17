package com.itany.nmms.service.impl;

import com.itany.nmms.constant.DictConstant;
import com.itany.nmms.constant.StatusConstant;
import com.itany.nmms.dao.DeptMapper;
import com.itany.nmms.dao.SequenceMapper;
import com.itany.nmms.entity.*;
import com.itany.nmms.exception.*;
import com.itany.nmms.service.DeptService;
import com.itany.nmms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private SequenceMapper sequenceMapper;

    @Override
    public void addDept(String deptName, String remark) throws RequestParameterErrorException, DeptExistException {
        if (StringUtil.isNull(deptName) || StringUtil.isNull(remark)) {
            throw new RequestParameterErrorException("请求参数异常");
        }
        DeptExample example = new DeptExample();
        example.createCriteria().andDeptNameEqualTo(deptName);
        List<Dept> depts = deptMapper.selectByExample(example);
        if (!depts.isEmpty()) {
            throw new DeptExistException("该部门已经存在");
        }
        Dept dept = new Dept();
        dept.setDeptName(deptName);
        dept.setRemark(remark);
        dept.setCreateDate(new Date());
        dept.setIsValid(StatusConstant.SYS_DEPT_TYPE_STATUS_DISABLE);

        // 生成商品编号
        SequenceExample sequenceExample = new SequenceExample();
        sequenceExample.createCriteria().andNameEqualTo(DictConstant.DEPT_NO_PREFIX);
        List<Sequence> sequences = sequenceMapper.selectByExample(sequenceExample);
        if (sequences.isEmpty()) {
            Sequence sequence = new Sequence();
            sequence.setName(DictConstant.DEPT_NO_PREFIX);
            sequence.setValue(DictConstant.DEPT_NO_SEQUENCE_INIT_VALUE);
            // 添加序列号
            sequenceMapper.insertSelective(sequence);
            // 生成对应的商品编号
            dept.setDeptNo(DictConstant.DEPT_NO_PREFIX + new SimpleDateFormat("yyyyMMdd").format(new Date()) + sequence.getValue());
        } else {
            Sequence sequence = sequences.get(0);
            // 如果序列号的值达到了最大值
            // 则下一个值为初始值
            if (sequence.getValue() == DictConstant.DEPT_NO_SEQUENCE_MAX_VALUE) {
                sequence.setValue(DictConstant.DEPT_NO_SEQUENCE_INIT_VALUE);
            } else {
                // 如果序列号尚未达到最大值则在原有基础上+1
                sequence.setValue(String.format("%06d", Integer.parseInt(sequence.getValue()) + 1));
            }
            // 修改序列号
            sequenceMapper.updateByPrimaryKeySelective(sequence);
            // 生成对应的商品编号
            dept.setDeptNo(DictConstant.DEPT_NO_PREFIX + new SimpleDateFormat("yyyyMMdd").format(new Date()) + sequence.getValue());
            deptMapper.insert(dept);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Dept findById(String deptId) throws RequestParameterErrorException {
        if(StringUtil.isNull(deptId)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        return deptMapper.selectByPrimaryKey(Integer.parseInt(deptId));
    }

    @Override
    public void modifyDept(String deptId, String deptName, String remark) throws RequestParameterErrorException, DeptExistException {
        if (StringUtil.isNull(deptId) || StringUtil.isNull(deptName) || StringUtil.isNull(remark)) {
            throw new RequestParameterErrorException("请求参数异常");
        }
        Dept dept = deptMapper.selectByPrimaryKey(Integer.parseInt(deptId));
        if(dept==null){
            throw new DeptExistException("该部门不存在");
        }
        Dept dept1 = new Dept();
        dept1.setDeptId(Integer.parseInt(deptId));
        dept1.setDeptName(deptName);
        dept1.setRemark(remark);
        deptMapper.updateByPrimaryKeySelective(dept1);
    }

    @Override
    public void remove(String deptId) throws RequestParameterErrorException, DeptExistException {
        if(StringUtil.isNull(deptId)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        Dept dept = deptMapper.selectByPrimaryKey(Integer.parseInt(deptId));
        if(dept==null){
            throw new DeptExistException("该商品不存在");
        }
        deptMapper.deleteByPrimaryKey(Integer.parseInt(deptId));
    }

    @Override
    public void addZdept(String fDeptId, String zDeptName, String zRemark) throws RequestParameterErrorException, DeptExistException {
        if(StringUtil.isNull(fDeptId)||StringUtil.isNull(zDeptName)||StringUtil.isNull(zRemark)){
            throw new RequestParameterErrorException("请求参数异常");
        }
        Dept dept = deptMapper.selectByPrimaryKey(Integer.parseInt(fDeptId));
        if(dept==null){
            throw new DeptExistException("该部门不存在");
        }
        DeptExample example = new DeptExample();
        example.createCriteria().andDeptNameEqualTo(zDeptName);
        List<Dept> depts = deptMapper.selectByExample(example);
        if(!depts.isEmpty()){
//            Dept zdept = depts.get(0);
//            zdept.setFatherDeptId(dept.getDeptId());
//            dept.setDept(zdept);
//            deptMapper.updateByPrimaryKeySelective(zdept);
            throw new DeptExistException("该部门已经存在");
        }else {
            addDept(zDeptName,zRemark);
            Dept zdept2 = deptMapper.selectByExample(example).get(0);
            zdept2.setFatherDeptId(dept.getDeptId());
            dept.setDept(zdept2);
            deptMapper.updateByPrimaryKeySelective(zdept2);
        }
        deptMapper.updateByPrimaryKeySelective(dept);
    }

    @Override
    public void modifyStatus(String deptId) throws Exception {
        if(StringUtil.isNull(deptId)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        Dept dept = deptMapper.selectByPrimaryKey(Integer.parseInt(deptId));
        if(dept==null){
            throw new DeptExistException("该数据不不存在，无法禁用");
        }
        int status = dept.getIsValid();

        if(status==StatusConstant.SYS_DEPT_TYPE_STATUS_ENABLE){
//            if(dept.getDept()!=null){
//                //禁用所有子部门
//                Dept dept1 = dept.getDept();
//                if(dept1.getIsValid()==StatusConstant.SYS_DEPT_TYPE_STATUS_ENABLE){
////                    dept1.setIsValid(StatusConstant.SYS_DEPT_TYPE_STATUS_DISABLE);
////                    deptMapper.updateByPrimaryKeySelective(dept1);
//                    modifyStatus(dept1.getDeptId()+"");
//                }
//            }
            dept.setIsValid(StatusConstant.SYS_DEPT_TYPE_STATUS_DISABLE);
            deptMapper.updateByPrimaryKeySelective(dept);
            // 查询当前部门直属的所有子部门
            DeptExample example = new DeptExample();
            example.or()
                    .andFatherDeptIdEqualTo(Integer.parseInt(deptId));
            List<Dept> sonDepts = deptMapper.selectByExample(example);
            for(Dept sonDept : sonDepts){
                if(sonDept.getIsValid()==StatusConstant.SYS_DEPT_TYPE_STATUS_ENABLE)
                    modifyStatus(sonDept.getDeptId().toString());
            }
        }else if(status==StatusConstant.SYS_DEPT_TYPE_STATUS_DISABLE){
            if(dept.getFatherDeptId()!=null){
                Dept fdept = deptMapper.selectByPrimaryKey(dept.getFatherDeptId());
                if(fdept.getIsValid()==StatusConstant.SYS_DEPT_TYPE_STATUS_DISABLE){
                    throw new DeptNoQXException("您没有权限开启");
                }else {
                    dept.setIsValid(StatusConstant.SYS_DEPT_TYPE_STATUS_ENABLE);
                    deptMapper.updateByPrimaryKeySelective(dept);
                }
            }else {
                dept.setIsValid(StatusConstant.SYS_DEPT_TYPE_STATUS_ENABLE);
                deptMapper.updateByPrimaryKeySelective(dept);
            }
        }
    }

    @Override
    public List<Dept> findEnable() throws DeptNotExistException {
        DeptExample example = new DeptExample();
        example.or()
                .andIsValidEqualTo(StatusConstant.SYS_DEPT_TYPE_STATUS_ENABLE);
        List<Dept> depts = deptMapper.selectByExample(example);
        if(depts.isEmpty()){
            throw new DeptNotExistException("没有可用的有效部门");
        }
        return depts;
    }
}
