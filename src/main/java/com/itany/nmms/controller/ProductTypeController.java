package com.itany.nmms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.nmms.constant.DictConstant;
import com.itany.nmms.constant.ResponseCodeConstant;
import com.itany.nmms.entity.ProductType;
import com.itany.nmms.exception.ProductTypeExistException;
import com.itany.nmms.exception.RequestParameterErrorException;
import com.itany.nmms.service.ProductTypeService;
import com.itany.nmms.util.ResponseResult;
import com.itany.nmms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/type")
public class ProductTypeController {

    @Autowired
    private ProductTypeService typeService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(String pageNo,String pageSize){
        ModelAndView mav = new ModelAndView();

        if(StringUtil.isNull(pageNo)){
            pageNo = DictConstant.PRODUCT_TYPE_DEFAULT_PAGE_NO;
        }
        if(StringUtil.isNull(pageSize)){
            pageSize = DictConstant.PRODUCT_TYPE_DEFAULT_PAGE_SIZE;
        }

        PageHelper.startPage(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
        List<ProductType> types = typeService.findAll();
        PageInfo<ProductType> pageTypes = new PageInfo<>(types);

        mav.addObject("pageTypes",pageTypes);
        mav.setViewName("backend/productTypeManager");
        return mav;
    }

    @ResponseBody
    @RequestMapping("/addType")
    public ResponseResult addType(String name){
        ResponseResult result = new ResponseResult();

        try {
            typeService.addType(name);
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
            result.setMessage("成功");
        } catch (RequestParameterErrorException e) {
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
            result.setMessage(e.getMessage());
        } catch (ProductTypeExistException e) {
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
            result.setMessage(e.getMessage());
        } catch (Exception e) {
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
            result.setMessage("服务器内部异常");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/findById")
    public ResponseResult findById(String id){
        ResponseResult result = new ResponseResult();

        try {
            ProductType type = typeService.findById(id);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
            result.setReturnObject(type);
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
    @RequestMapping("/modifyName")
    public ResponseResult modifyName(String id, String name){
        ResponseResult result = new ResponseResult();

        try {
            typeService.modifyName(id,name);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        } catch (ProductTypeExistException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        } catch (Exception e) {
            result.setMessage("服务器内部异常");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_FAIL);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/modifyStatus")
    public ResponseResult modifyStatus(String id){
        ResponseResult result = new ResponseResult();

        try {
            typeService.modifyStatus(id);
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

}
