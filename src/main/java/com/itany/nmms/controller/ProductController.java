package com.itany.nmms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.nmms.constant.DictConstant;
import com.itany.nmms.constant.ResponseCodeConstant;
import com.itany.nmms.entity.Product;
import com.itany.nmms.entity.ProductType;
import com.itany.nmms.exception.ProductExistException;
import com.itany.nmms.exception.ProductTypeExistException;
import com.itany.nmms.exception.RequestParameterErrorException;
import com.itany.nmms.service.ProductService;
import com.itany.nmms.service.ProductTypeService;
import com.itany.nmms.util.ResponseResult;
import com.itany.nmms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductTypeService typeService;

    @Autowired
    private ProductService productService;

    @ModelAttribute("types")
    public List<ProductType> findEnable(){
        List<ProductType> types = typeService.findEnable();
        return types;
    }

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
        List<Product> products = productService.findAll();
        PageInfo<Product> pageProducts = new PageInfo<>(products);

        mav.addObject("pageProducts",pageProducts);

        mav.setViewName("backend/productManager");
        return mav;
    }

    @ResponseBody
    @RequestMapping("/addProduct")
    public ResponseResult addProduct(String name, String price, @RequestParam("file") MultipartFile file, String typeId, HttpSession session){
        ResponseResult result = new ResponseResult();

        try {
            productService.addProduct(name,price,file,typeId,session);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
        } catch (RequestParameterErrorException e) {
            result.setMessage(e.getMessage());
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_REQUEST_PARAMETER_ERROR);
        } catch (ProductExistException e) {
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
    @RequestMapping("/findStatusById")
    public ResponseResult findStatusById(String id){
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
    @RequestMapping("/findById")
    public ResponseResult findById(String id){
        ResponseResult result = new ResponseResult();

        try {
            Product product = productService.findById(id);
            result.setMessage("成功");
            result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
            result.setReturnObject(product);
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
    @RequestMapping("/modifyProduct")
    public ResponseResult modifyProduct(String productId, String name, String price, @RequestParam("file") MultipartFile file, String productTypeId, HttpSession session){
        ResponseResult result = new ResponseResult();

        try {
            System.out.println(123);
            productService.modifyProduct(productId,name,price,file,productTypeId,session);
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

    @RequestMapping("/remove")
    @ResponseBody
    public ResponseResult remove(String id){
        ResponseResult result = new ResponseResult();
        try {
            productService.remove(id);
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
