package com.itany.nmms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.nmms.constant.DictConstant;
import com.itany.nmms.constant.ResponseCodeConstant;
import com.itany.nmms.entity.Dept;
import com.itany.nmms.exception.DeptExistException;
import com.itany.nmms.exception.DeptNoQXException;
import com.itany.nmms.exception.RequestParameterErrorException;
import com.itany.nmms.service.DeptService;
import com.itany.nmms.util.ResponseResult;
import com.itany.nmms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(String pageNo, String pageSize){
        ModelAndView mav = new ModelAndView();
        if(StringUtil.isNull(pageNo)){
            pageNo = DictConstant.PRODUCT_TYPE_DEFAULT_PAGE_NO;
        }
        if(StringUtil.isNull(pageSize)){
            pageSize = DictConstant.PRODUCT_TYPE_DEFAULT_PAGE_SIZE;
        }
        PageHelper.startPage(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
        List<Dept> depts = deptService.findAll();
        PageInfo<Dept> pageDepts = new PageInfo<>(depts);
        mav.addObject("pageDepts",pageDepts);
        mav.setViewName("backend/deptManager");
        return mav;
    }

    @ResponseBody
    @RequestMapping("/addDept")
    public ResponseResult addDept(String deptName, String remark){
        ResponseResult result = new ResponseResult();
        try {
            deptService.addDept(deptName,remark);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        } catch (DeptExistException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("服务器内部异常");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/addZdept")
    public ResponseResult addZdept(String fDeptId, String zDeptName, String zRemark){
        ResponseResult result = new ResponseResult();
        try {
            deptService.addZdept(fDeptId,zDeptName,zRemark);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        } catch (DeptExistException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("服务器内部异常");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        }
        return result;
    }
    @ResponseBody
    @RequestMapping("/findById")
    public ResponseResult findById(String deptId){
        ResponseResult result = new ResponseResult();

        try {
            Dept dept = deptService.findById(deptId);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
            result.setReturnObject(dept);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        } catch (Exception e) {
            result.setMessage("服务器内部异常");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/modifyDept")
    public ResponseResult modifyDept(String deptId, String deptName, String remark){
        ResponseResult result = new ResponseResult();

        try {
            deptService.modifyDept(deptId,deptName,remark);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        } catch (Exception e) {
            result.setMessage("服务器内部异常");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/remove")
    public ResponseResult remove(String deptId){
        ResponseResult result = new ResponseResult();
        try {
            deptService.remove(deptId);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        } catch (Exception e) {
            result.setMessage("服务器内部异常");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        }
        return result;
    }
    @ResponseBody
    @RequestMapping("/modifyStatus")
    public ResponseResult modifyStatus(String deptId){
        ResponseResult result = new ResponseResult();

        try {
            deptService.modifyStatus(deptId);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        }catch (DeptNoQXException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        } catch (Exception e) {
            result.setMessage("服务器内部异常");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        }

        return result;
    }

}
