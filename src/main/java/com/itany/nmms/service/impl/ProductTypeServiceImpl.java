package com.itany.nmms.service.impl;

import com.itany.nmms.constant.StatusConstant;
import com.itany.nmms.dao.ProductTypeMapper;
import com.itany.nmms.entity.ProductType;
import com.itany.nmms.entity.ProductTypeExample;
import com.itany.nmms.exception.ProductTypeExistException;
import com.itany.nmms.exception.RequestParameterErrorException;
import com.itany.nmms.service.ProductTypeService;
import com.itany.nmms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeMapper typeMapper;

    @Override
    public void addType(String name) throws RequestParameterErrorException, ProductTypeExistException {
        if(StringUtil.isNull(name)){
            throw new RequestParameterErrorException("请求参数有误");
        }

        ProductTypeExample example = new ProductTypeExample();
        example.or()
                .andNameEqualTo(name);
        List<ProductType> types = typeMapper.selectByExample(example);
        if(!types.isEmpty()){
            throw new ProductTypeExistException("该商品类型已经存在");
        }

        ProductType type = new ProductType();
        type.setName(name);
        // 新增的商品类型默认为启用状态
        type.setStatus(StatusConstant.SYS_PRODUCT_TYPE_STATUS_ENABLE);

        typeMapper.insertSelective(type);

    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<ProductType> findAll() {
        List<ProductType> types = typeMapper.selectByExample(new ProductTypeExample());
        return types.isEmpty()?null:types;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public ProductType findById(String id) throws RequestParameterErrorException {
        if(StringUtil.isNull(id)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        ProductType type = typeMapper.selectByPrimaryKey(Integer.parseInt(id));
        return type;
    }

    @Override
    public void modifyName(String id, String name) throws RequestParameterErrorException, ProductTypeExistException {
        if(StringUtil.isNull(id) || StringUtil.isNull(name)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        ProductTypeExample example = new ProductTypeExample();
        example.or()
                .andIdNotEqualTo(Integer.parseInt(id))
                .andNameEqualTo(name);
        List<ProductType> types = typeMapper.selectByExample(example);
        if(!types.isEmpty()){
            throw new ProductTypeExistException("该商品类型已经存在");
        }
        ProductType type = new ProductType();
        type.setId(Integer.parseInt(id));
        type.setName(name);
        typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public void modifyStatus(String id) throws RequestParameterErrorException {
        if(StringUtil.isNull(id)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        ProductType type = typeMapper.selectByPrimaryKey(Integer.parseInt(id));
        if(type.getStatus() == StatusConstant.SYS_PRODUCT_TYPE_STATUS_ENABLE){
            type.setStatus(StatusConstant.SYS_PRODUCT_TYPE_STATUS_DISABLE);
        }else{
            type.setStatus(StatusConstant.SYS_PRODUCT_TYPE_STATUS_ENABLE);
        }
        typeMapper.updateByPrimaryKeySelective(type);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<ProductType> findEnable() {
        ProductTypeExample example = new ProductTypeExample();
        example.or()
                .andStatusEqualTo(StatusConstant.SYS_PRODUCT_TYPE_STATUS_ENABLE);
        List<ProductType> types = typeMapper.selectByExample(example);
        return types.isEmpty()?null:types;
    }

}
