package com.itany.nmms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.nmms.constant.DictConstant;
import com.itany.nmms.constant.ResponseCodeConstant;
import com.itany.nmms.entity.Dept;
import com.itany.nmms.entity.Staff;
import com.itany.nmms.exception.*;
import com.itany.nmms.service.DeptService;
import com.itany.nmms.service.StaffService;
import com.itany.nmms.util.ResponseResult;
import com.itany.nmms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private DeptService deptService;

    @RequestMapping("/login")
    public ModelAndView login(String loginName, String password, String role, String code, HttpSession session){
        ModelAndView mav = new ModelAndView();
        String image = (String) session.getAttribute("code");
        try {
            Staff staff = staffService.login(loginName,password,role,code,image);
            mav.setViewName("redirect:/showMain");
            session.setAttribute("staff",staff);
        } catch (RequestParameterErrorException e) {
            mav.setViewName("backend/login");
            mav.addObject("loginMsg",e.getMessage());
        } catch (CodeErrorException e) {
            mav.setViewName("backend/login");
            mav.addObject("loginMsg",e.getMessage());
        } catch (StaffNotExistException e) {
            mav.setViewName("backend/login");
            mav.addObject("loginMsg",e.getMessage());
        }
        return mav;
    }
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session, ModelAndView mv){
        session.invalidate();
        mv.setViewName("redirect:/showLogin");
        return mv;
    }
    @RequestMapping("/findByParams")
    public ModelAndView findByParams(Staff staffParameter,String pageNo,String pageSize){
        ModelAndView mav = new ModelAndView();
        if(StringUtil.isNull(pageNo)){
            pageNo = DictConstant.STAFF_DEFAULT_PAGE_NO;
        }
        if(StringUtil.isNull(pageSize)){
            pageSize = DictConstant.STAFF_DEFAULT_PAGE_SIZE;
        }
        PageHelper.startPage(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
        List<Staff> staffs = staffService.findByParams(staffParameter);
        if(staffs!=null){
            PageInfo<Staff> pageStaffs = new PageInfo<>(staffs);
            mav.addObject("pageStaffs",pageStaffs);
            mav.addObject("staffParameter",staffParameter);
        }
        mav.setViewName("backend/staffManager");
        return mav;
    }

    @ModelAttribute("depts")
    public List<Dept> findEnable(ModelMap modelMap){
        List<Dept> depts = new ArrayList<>();
        try {
            depts = deptService.findEnable();
        } catch (DeptNotExistException e) {
            e.printStackTrace();
            modelMap.addAttribute("staffMsg",e.getMessage());
        }
        return depts;
    }

    @ResponseBody
    @RequestMapping("/addStaff")
    public ResponseResult addStaff(Staff staffParameter,HttpSession session){
        ResponseResult result  = new ResponseResult();

        Staff staff = (Staff) session.getAttribute("staff");

        try {
            staffService.addStaff(staffParameter,staff);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
        } catch (LoginDisableException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_LOGIN_TIMEOUT);
        } catch (NoPromissionException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_NO_PROMISSION);
        } catch (StaffExistException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("服务器内部异常");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        }

        return result;
    }


    @ResponseBody
    @RequestMapping("/findById")
    public ResponseResult findById(String id){
        ResponseResult result  = new ResponseResult();

        try {
            Staff staff = staffService.findById(id);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
            result.setReturnObject(staff);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("服务器内部异常");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/modifyStaff")
    public ResponseResult modifyStaff(Staff staffParameter){
        ResponseResult result  = new ResponseResult();

        try {
            staffService.modifyStaff(staffParameter);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("服务器内部异常");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/modifyStatus")
    public ResponseResult modifyStatus(String id){
        ResponseResult result  = new ResponseResult();

        try {
            staffService.modifyStatus(id);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("服务器内部异常");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        }
        return result;
    }
}
