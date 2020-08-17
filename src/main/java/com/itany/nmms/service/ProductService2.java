package com.itany.nmms.service;

import com.itany.nmms.entity.Product;

import java.util.List;

public interface ProductService2 {

    int addProduct(Product product);

    int alterSelectByPrimaryKey(Product product);

    int delProductByPrimaryKey(int id);

    List<Product> findAll();
}
