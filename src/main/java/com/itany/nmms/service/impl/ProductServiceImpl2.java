package com.itany.nmms.service.impl;

import com.itany.nmms.dao.ProductMapper;
import com.itany.nmms.entity.Product;
import com.itany.nmms.entity.ProductExample;
import com.itany.nmms.entity.ProductType;
import com.itany.nmms.exception.RequestParameterErrorException;
import com.itany.nmms.service.ProductService2;
import com.itany.nmms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl2 implements ProductService2 {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int addProduct(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int alterSelectByPrimaryKey(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public int delProductByPrimaryKey(int id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Product> findAll() {
        ProductExample example = new ProductExample();
        return productMapper.selectByExample(example);
    }



}
