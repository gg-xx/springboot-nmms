package com.itany.nmms.service;

import com.itany.nmms.entity.ProductType;
import com.itany.nmms.exception.ProductTypeExistException;
import com.itany.nmms.exception.RequestParameterErrorException;

import java.util.List;

public interface ProductTypeService {

    /**
     * 添加商品类型
     * 类型名称不能重复
     * @param name
     */
    public void addType(String name) throws RequestParameterErrorException, ProductTypeExistException;

    /**
     * 查询所有商品类型
     * @return
     */
    public List<ProductType> findAll();

    /**
     * 修改设置默认值
     * @param id
     * @return
     */
    public ProductType findById(String id) throws RequestParameterErrorException;

    /**
     * 修改类型名称
     * @param id
     * @param name
     */
    public void modifyName(String id, String name) throws RequestParameterErrorException, ProductTypeExistException;

    /**
     * 启用与禁用
     * @param id
     */
    public void modifyStatus(String id) throws RequestParameterErrorException;

    /**
     * 查询有效的商品类型
     * @return
     */
    public List<ProductType> findEnable();
}
